package boy.learning.config;


import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.context.annotation.*;

import javax.sql.DataSource;

//配置
@Configuration
//包扫描
@ComponentScan({"boy.learning"})
//配置properties
@PropertySource({"jdbc.properties","jdbc.properties","jdbc.properties"})
//导入第三方bean
@Import({JdbcConfig.class})
public class SpringConfig {
}
