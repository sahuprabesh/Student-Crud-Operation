package p1.p2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "p1.p2")
public class Configgg extends WebMvcConfigurerAdapter {

	public void ConfigureDefaultServletHandling(DefaultServletHandlerConfigurer ob)
	{
		System.out.println("Enable method for static request execute");
		ob.enable();
	}
	
	@Bean
	public InternalResourceViewResolver getInternal()
	{
		System.out.println("config object created");
		InternalResourceViewResolver irv=new InternalResourceViewResolver();
		irv.setViewClass(JstlView.class);
		irv.setPrefix("/WEB-INF/views/");
		irv.setSuffix(".jsp");
		return irv;
	}
	
}
