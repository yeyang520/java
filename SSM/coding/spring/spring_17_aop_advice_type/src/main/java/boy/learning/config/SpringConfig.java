package boy.learning.config;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan({"boy.learning"})
//告诉spring有用注解开发的AOP ， 启动了 @Aspect
@EnableAspectJAutoProxy
public class SpringConfig {
}
