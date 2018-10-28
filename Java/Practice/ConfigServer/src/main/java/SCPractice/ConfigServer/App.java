package SCPractice.ConfigServer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

/**
 * Hello world!
 *
 */
@SpringBootConfiguration
@EnableAutoConfiguration 
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        SpringApplication.run(SpringApplication.class, args);
    }
}
