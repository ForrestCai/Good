using RabbitMQ.Client;
using RabbitMQ.Client.Events;
using System;
using System.Text;
using System.Threading;

namespace Subscriber
{
    public class Program
    {
        public static void Main(string[] args)
        {
            var factory = new ConnectionFactory() { HostName = "192.168.0.131", Port = 5673, UserName = "guest", Password = "guest", Protocol = Protocols.AMQP_0_9_1 };
            var connection = factory.CreateConnection();
            var channel = connection.CreateModel();

            var queue = channel.QueueDeclare(queue: "Test",
                                 durable: true,
                                 exclusive: false,
                                 autoDelete: false,
                                 arguments: null);

            channel.BasicQos(prefetchSize: 0, prefetchCount: 3, global: false);

            //channel.QueueBind(queue: queue.QueueName,
            //                  exchange: "",
            //                  routingKey: "");                              );

            var consumer = new EventingBasicConsumer(channel);
            consumer.Received += (model, ea) =>
            {
                var body = ea.Body;
                var message = Encoding.UTF8.GetString(body);
                Console.WriteLine("Received {0}", message);
                Thread.Sleep(5000);
                Console.WriteLine("Finished {0}", message);
                channel.BasicAck(deliveryTag: ea.DeliveryTag, multiple: false);
            };

            channel.BasicConsume(queue: queue.QueueName,                                
                                 noAck: false,
                                 consumer: consumer);

            Console.WriteLine("Started");
        }
    }
}
