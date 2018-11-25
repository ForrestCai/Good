package test.processors;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;

@Component
public class TestProcessor implements Processor {
    public void process(Exchange exchange) throws Exception {
        System.out.println("Processing" + exchange);
    }
}
