package Practice.FirstProject;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix="web")

@PropertySources({
	@PropertySource(value="classpath:my.properties", ignoreResourceNotFound=true),
	@PropertySource(value="file:./my.properties", ignoreResourceNotFound=true)
})

@Component
public class MyConfig {
	private String test3;

	public String getTest3() {
		return test3;
	}

	public void setTest3(String test3) {
		this.test3 = test3;
	}
}
