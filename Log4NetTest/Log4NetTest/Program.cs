using log4net;
using System;

namespace Log4NetTest
{
    class Program
    {
        static void Main(string[] args)
        {
            var logger = LogManager.GetLogger("Log");
            logger.Error("1234");

            logger.Error("abcd");


            var logger2 = LogManager.GetLogger("TimingLog");
            logger2.Error("1234");

            logger2.Error("abcd");
            Console.ReadKey();
        }
    }
}
