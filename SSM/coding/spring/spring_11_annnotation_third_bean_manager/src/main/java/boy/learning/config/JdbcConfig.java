package boy.learning.config;

import boy.learning.dao.BookDao;
import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

public class JdbcConfig {

    @Value("com.mysql.jdbc.driver")
    private String driver;
    @Value("jdbc:mysql://localhost:3306/db1")
    private String url;
    @Value("root")
    private String username;
    @Value("123456")
    private String password;


    //1.定义一个方法获得要管理的对象
    //2.添加@bean，表示当前返回的是一个bean对象
    @Bean
    public DataSource dataSource(BookDao bookDao){

        System.out.println(bookDao);

        DruidDataSource ds = new DruidDataSource();
        ds.setDriverClassName(driver);
        ds.setUrl(url);
        ds.setUsername(username);
        ds.setPassword(password);
        return ds;
    }
}
