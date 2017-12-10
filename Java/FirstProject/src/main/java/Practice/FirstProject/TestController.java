package Practice.FirstProject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
/*import test.MyUtil;*/

@RestController
@Api(value = "用户模块")
@RequestMapping("/user")
public class TestController {
	
	@Value("${test2}")
	private String test;
	
    @Autowired
    private MyConfig myConfig;
	
    @RequestMapping(value = "/", method = RequestMethod.POST)
    @ApiOperation(value = "更新用户", notes = "更新已存在用户")    
    public String Test()
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
		
    	return test + myConfig.getTest3() + System.getProperty("user.dir");
/*    	MyUtil test = new MyUtil();
    	return test.GetMessage();*/
    }
}
