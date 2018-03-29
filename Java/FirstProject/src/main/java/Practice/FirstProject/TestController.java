package Practice.FirstProject;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(value = "用户模块")
@RequestMapping("/user")
public class TestController {
	
	@Value("${test2}")
	private String test;
	
    @Autowired
    private MyConfig myConfig;
	
    @Autowired
    RestTemplate resttemplate;
    
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
    
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    @ApiOperation(value = "上传", notes = "")  
    public String upload(@RequestParam String test)
    {    	
    	HttpHeaders headers = new HttpHeaders();
    	headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

    	MultiValueMap<String, String> map= new LinkedMultiValueMap<String, String>();
    	map.add("test", "first.last@example.com");

    	HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(map, headers);

    	ResponseEntity<String> response = resttemplate.postForEntity( "http://localhost:8080/user/upload", request , String.class );
    	return "got " + test;
    }
    
    @RequestMapping(value = "/upload2", method = RequestMethod.POST)
    @ApiOperation(value = "上传", notes = "")
    public String upload2( @RequestParam("file") MultipartFile uploadfile)
    {
        String url = "http://127.0.0.1:8080/test/upload.do";  
        String filePath = "C:\\Users\\MikanMu\\Desktop\\test.txt";  
      
        RestTemplate rest = new RestTemplate();  
        FileSystemResource resource = new FileSystemResource(new File(filePath));  
        MultiValueMap<String, Object> param = new LinkedMultiValueMap<String, Object>();  
        param.add("jarFile", resource);  
        param.add("fileName", "test.txt");  
      
        String string = rest.postForObject(url, param, String.class);  
        System.out.println(string);  
        
    	return "good";
    }
}
