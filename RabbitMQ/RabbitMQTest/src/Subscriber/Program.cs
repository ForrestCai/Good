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
            var factory = new ConnectionFactory() { HostName = "192.168.0.131", Port = 5673, UserName = "guest", Password = "guest", Protocol = Protocols.AMQP_0_9_1, AutomaticRecoveryEnabled = true };
            var connection = factory.CreateConnection();
            var channel = connection.CreateModel();

            channel.ExchangeDeclare("TestExchange", "fanout", true, false);

            var queue = channel.QueueDeclare(queue: "Test",
                                 durable: true,
                                 exclusive: false,
                                 autoDelete: false,
                                 arguments: null);

            channel.BasicQos(prefetchSize: 0, prefetchCount: 3, global: false);

            channel.QueueBind(queue: queue.QueueName,
                              exchange: "TestExchange",
                              routingKey: "");

            var consumer = new EventingBasicConsumer(channel);
            consumer.Received += (model, ea) =>
            {
                var body = ea.Body;
                var message = Encoding.UTF8.GetString(body);
                Console.WriteLine($"Thread {Thread.CurrentThread.ManagedThreadId} Received {message}");
                Thread.Sleep(5000);
                Console.WriteLine($"Thread {Thread.CurrentThread.ManagedThreadId} Finished {message}");
                channel.BasicAck(deliveryTag: ea.DeliveryTag, multiple: false);
            };

            channel.BasicConsume(queue: queue.QueueName,                                
                                 noAck: false,
                                 consumer: consumer);

            Console.WriteLine("Started");
        }
    }
}
