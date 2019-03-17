package test.processors;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class TestProcessor implements Processor {
    private final static Logger logger = LoggerFactory.getLogger(TestProcessor.class);
    private final static Logger audittraceLogger = LoggerFactory.getLogger("audittrace");
    public void process(Exchange exchange) throws Exception {
        System.out.println("Processing" + exchange);
        logger.debug("Processing" + exchange);
        logger.error("Processing" + exchange);
        audittraceLogger.info("audit test!");

        Thread.sleep(10000);
    }
}
