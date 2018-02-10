package ElasticSearchTest.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(value = "站点模块")
@RequestMapping("/site")
public class ESController {
	
    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ApiOperation(value = "添加站点", notes = "添加站点信息")
    public ResponseEntity<?> addSite()
    {
    	
    	return new ResponseEntity("Hello!", HttpStatus.OK);
    }
}
