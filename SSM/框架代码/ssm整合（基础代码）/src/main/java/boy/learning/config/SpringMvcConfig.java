package boy.learning.config;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

//Spring的核心配置类得写该注释
@Configuration
@ComponentScan("boy.learning.controller")
//代表很多功能，比如开启json数据转化
@EnableWebMvc
public class SpringMvcConfig {


}
