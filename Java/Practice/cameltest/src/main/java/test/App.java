package test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

@SpringBootApplication
//@ComponentScan
//@EnableAutoConfiguration
public class App {
    public static void main(String[] args) throws IOException {
        Enumeration<URL> urls = App.class.getClassLoader().getResources("META-INF/spring.factories");
        SpringApplication.run(App.class, args);

        ThreadPoolExecutor x
    }
}


