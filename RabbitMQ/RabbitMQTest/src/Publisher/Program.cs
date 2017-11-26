using RabbitMQ.Client;
using System;
using System.Text;

namespace Publisher
{
    public class Program
    {
        public static void Main(string[] args)
        {
            var input = Console.ReadLine();

            var factory = new ConnectionFactory() { HostName = "192.168.0.131", Port = 5673, UserName = "guest", Password = "guest", Protocol = Protocols.AMQP_0_9_1 };

            using (var connection = factory.CreateConnection())
            {
                using (var channel = connection.CreateModel())
                {
                    while (!input.Equals("exit"))
                    {
                        //channel.ExchangeDeclare(exchange: "Test", type: "direct", durable: true);

                        //channel.QueueDeclare(queue: "test",
                        //         durable: false,
                        //         exclusive: false,
                        //         autoDelete: false,
                        //         arguments: null);

                        string message = input;
                        var body = Encoding.UTF8.GetBytes(message);

                        var p = channel.CreateBasicProperties();
                        p.Persistent = true;

                        channel.BasicPublish(exchange: "",
                                             routingKey: "Test",
                                             basicProperties: p,
                                             body: body);

                        Console.WriteLine("Sent {0}", message);

                        input = Console.ReadLine();
                    }
                }
            }
        }
    }
}
