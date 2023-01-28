package boy.learning.config;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan({"boy.learning.service"})
//加载jdbc.properties文件
@PropertySource("classPath:jdbc.properties")
//加载配置类
@Import({JdbcConfig.class, MyBatisConfig.class})
public class SpringConfig {
}
