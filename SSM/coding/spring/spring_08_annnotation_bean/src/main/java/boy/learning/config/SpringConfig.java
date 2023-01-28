package boy.learning.config;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({"boy.learning.service","boy.learning.dao"})
public class SpringConfig {
}
