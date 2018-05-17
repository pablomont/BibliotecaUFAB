package uepb.web.ufab.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;



@Configuration
@ComponentScan("uepb.web.ufab")
@Import(DBConfig.class)
@EnableWebMvc   
public class AppConfig extends WebMvcConfigurerAdapter{
	
	@Bean  
    public InternalResourceViewResolver viewResolver() {  
	    InternalResourceViewResolver resolver = new InternalResourceViewResolver();  
            resolver.setPrefix("/WEB-INF/views/");  
            resolver.setSuffix(".jsp");
            return resolver;  
    }
	
	
}
