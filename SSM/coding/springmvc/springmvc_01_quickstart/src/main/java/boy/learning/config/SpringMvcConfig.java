package boy.learning.config;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


//3.创建SpringMVC的配置文件，加载controller对应的bean
@Configuration
@ComponentScan("boy.learning.controller")
public class SpringMvcConfig {
}
