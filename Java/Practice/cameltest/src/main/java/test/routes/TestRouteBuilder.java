package test.routes;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import test.processors.TestProcessor;

@Component
public class TestRouteBuilder extends RouteBuilder {

    @Autowired
    TestProcessor processor;

    public void configure() {
        from("timer://timer1?period=10000")
                .process(processor);
    }
}
