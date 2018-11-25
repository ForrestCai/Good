package test.routes;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class DynamicRouteBuilder extends RouteBuilder {
    public void configure() {

        from("direct:channel1").log("from channel1");
        from("direct:channel2").log("from channel2");

        from("timer://timer1?period=10000")
                // use a bean as the dynamic router
                .dynamicRouter(method(DynamicRouterTest.class, "slip"));
    }

    public static class DynamicRouterTest
    {
        private static int invokes;
        public static String slip()
        {
            invokes++;

            if(invokes > 10)
            {
                return null;
            }

            if (invokes % 2 == 0)
            {
                return "direct:channel1";
            }

            return "direct:channel2";
        }
    }
}
