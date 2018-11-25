package test.routes;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

//@Component
public class RecipientListRouteBuilder extends RouteBuilder {

    public void configure() {

        from("direct:channel1").log("from channel1");
        from("direct:channel2").log("from channel2");

        from("timer://timer1?period=10000")
                .setHeader("myHeader",constant("direct:channel1,direct:channel2"))
                .recipientList(header("myHeader"));
//                .parallelProcessing();
    }
}
