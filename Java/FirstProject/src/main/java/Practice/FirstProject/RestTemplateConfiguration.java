package Practice.FirstProject;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfiguration {

  //创建HTTP客户端工厂
//  private ClientHttpRequestFactory createFactory() {
//    if (this.maxTotalConnect <= 0) {
//      SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
//      factory.setConnectTimeout(this.connectTimeout);
//      factory.setReadTimeout(this.readTimeout);
//      return factory;
//    }
//    HttpClient httpClient = HttpClientBuilder.create().setMaxConnTotal(this.maxTotalConnect)
//        .setMaxConnPerRoute(this.maxConnectPerRoute).build();
//    HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory(
//        httpClient);
//    factory.setConnectTimeout(this.connectTimeout);
//    factory.setReadTimeout(this.readTimeout);
//    return factory;
//  }

  //初始化RestTemplate,并加入spring的Bean工厂，由spring统一管理
  @Bean
  public RestTemplate getRestTemplate() {
    RestTemplate restTemplate = new RestTemplate();
//    List<HttpMessageConverter<?>> converterList = restTemplate.getMessageConverters();
//
//    //重新设置StringHttpMessageConverter字符集为UTF-8，解决中文乱码问题
//    HttpMessageConverter<?> converterTarget = null;
//    for (HttpMessageConverter<?> item : converterList) {
//      if (StringHttpMessageConverter.class == item.getClass()) {
//        converterTarget = item;
//        break;
//      }
//    }
//    if (null != converterTarget) {
//      converterList.remove(converterTarget);
//    }
//    converterList.add(1, new StringHttpMessageConverter(StandardCharsets.UTF_8));
//
//    //加入FastJson转换器
//    converterList.add(new FastJsonHttpMessageConverter4());
    return restTemplate;
  }

}