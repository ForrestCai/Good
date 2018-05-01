package Practice.FirstProject;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
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
    
    @RequestMapping(value = "/upload3", method = RequestMethod.POST)
    @ApiOperation(value = "上传", notes = "")
    public String upload3()
    {
        String url = "http://localhost:8011/user/upload2";  
        String filePath = "C:\\Users\\forrest\\Desktop\\1.txt";  
      
        RestTemplate rest = new RestTemplate();  
//        FileSystemResource resource = new FileSystemResource(new File(filePath));
        
//        InputStream is = new ByteArrayInputStream("good test".getBytes());        
//        InputStreamResource resource = new InputStreamResource(is){   
//            @Override  
//            public String getFilename() throws IllegalStateException {   
//                return "c://1.test";  
//            }              
//        };
//        
        
        ByteArrayResource resource = new ByteArrayResource("good test".getBytes()){   
                @Override  
                public String getFilename() throws IllegalStateException {   
                    return "c://1.test";  
                }  
                  
            }; 
            
        
        MultiValueMap<String, Object> param = new LinkedMultiValueMap<String, Object>();  
        param.add("file", resource); 
      
        String string = rest.postForObject(url, param, String.class);  
        System.out.println(string);  
        
    	return "good";
    }
    
    @RequestMapping(value = "/download", method = RequestMethod.POST)
    @ApiOperation(value = "下载", notes = "")
    public ResponseEntity<InputStreamResource> download() throws IOException
    {
    	 String filePath = "C:\\Users\\forrest\\Desktop\\1.txt";  
         FileSystemResource file = new FileSystemResource(filePath);  
         HttpHeaders headers = new HttpHeaders();  
         headers.add("Cache-Control", "no-cache, no-store, must-revalidate");  
         headers.add("Content-Disposition", String.format("attachment; filename=\"%s\"", file.getFilename()));  
         headers.add("Pragma", "no-cache");  
         headers.add("Expires", "0");  
   
         return ResponseEntity
                 .ok()  
                 .headers(headers)  
                 .contentLength(file.contentLength())  
                 .contentType(MediaType.parseMediaType("application/octet-stream"))  
                 .body(new InputStreamResource(file.getInputStream()));  
    }
    
    @RequestMapping(value = "/download2", method = RequestMethod.POST)
    @ApiOperation(value = "下载", notes = "")
    public void download2(HttpServletResponse response) throws IOException
    {
    	 // Get your file stream from wherever.  
    	String filePath = "C:\\Users\\forrest\\Desktop\\1.txt";   
        File downloadFile = new File(filePath);  
  
        // set content attributes for the response  
        response.setContentType("application/octet-stream");  
        response.setContentLength((int) downloadFile.length());  
  
        // set headers for the response  
        String headerKey = "Content-Disposition";  
        String headerValue = String.format("attachment; filename=\"%s\"",  
                downloadFile.getName());  
        response.setHeader(headerKey, headerValue);  
  
        // Copy the stream to the response's output stream.
        try {  
            InputStream myStream = new FileInputStream(filePath);  
            IOUtils.copy(myStream, response.getOutputStream());  
            response.flushBuffer();  
        } catch (IOException e) {  
            e.printStackTrace();  
        }   
    }
    
    @RequestMapping(value = "/download3", method = RequestMethod.POST)
    @ApiOperation(value = "下载", notes = "")
    public ResponseEntity<byte[]> download3() throws IOException
    {
        HttpHeaders headers=new HttpHeaders();  
        headers.add("Content-Disposition","attachment;filename=11.txt");  
   
        HttpStatus statusCode=HttpStatus.OK;  
   
        ResponseEntity<byte[]> response=new ResponseEntity<byte[]>("good test".getBytes(),headers,statusCode);  
        return response;  
    }
    
    @RequestMapping(value = "/downloadtest", method = RequestMethod.GET)
    @ApiOperation(value = "下载测试", notes = "")
    public void downloadtest()
    {
        String url = "http://localhost:8011/user/download3"; 
        RestTemplate rest = new RestTemplate();  
        ResponseEntity<byte[]> response = rest.exchange(
                url,
                HttpMethod.POST,
                null,
                byte[].class);

            byte[] result = response.getBody();
    }
}
