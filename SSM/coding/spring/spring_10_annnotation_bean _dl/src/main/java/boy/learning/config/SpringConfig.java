package boy.learning.config;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;

@Configuration
@ComponentScan({"boy.learning"})
@PropertySource({"jdbc.properties","jdbc.properties","jdbc.properties"})
public class SpringConfig {
}
