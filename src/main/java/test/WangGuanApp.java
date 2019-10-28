package test;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;


//声明启动类
@EnableZuulProxy
@SpringCloudApplication
public class WangGuanApp 
{
    public static void main( String[] args )
    {
    	new SpringApplicationBuilder(WangGuanApp.class).web(true).run(args);
    }
    
  //启动类加bean
    @Bean
    public AccessFilter accessFilter(){
    	return new AccessFilter();
    }
}
