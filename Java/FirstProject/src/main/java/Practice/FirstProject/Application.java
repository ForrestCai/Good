package Practice.FirstProject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
/**
 * Hello world!
 *
 */
@SpringBootApplication
public class Application 
{
	@Autowired
	private UserRepository userRepository;
	
	@Value("${spring.data.mongodb.host}")
	private String test;
	
    public static void main( String[] args )
    {	
    	SpringApplication.run(Application.class, args);     	   	
    }
    
    @RequestMapping("/")
    @ApiOperation(value = "更新用户", notes = "更新已存在用户")
    public String Test(@ApiParam(value = "用户Id", required = true) @RequestBody  User user)
    {    	
/*		userRepository.save(new User(1L, "didi", 30));
		userRepository.save(new User(2L, "mama", 40));
		userRepository.save(new User(3L, "kaka", 50));

		// 删除一个User，再验证User总数
		User u = userRepository.findOne(1L);
		userRepository.delete(u);

		// 删除一个User，再验证User总数
		u = userRepository.findByUsername("mama");
		userRepository.delete(u);*/
		
    	return test;
    }
}
