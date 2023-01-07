package boy.learning;


import boy.learning.mapper.UserMapper;
import boy.learning.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;


/**
 * MyBatis 代理开发
 */
public class MyBatisDemo2 {

    public static void main(String[] args) throws IOException {
//        1.加载MyBatis核心配置文件，获取SqlSessionFactory对象
        String resource = "mybatis-config.xml";
//        传入字符串，返回字节输入流
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

//        2.获取SqlSession对象，用来执行sql
        SqlSession sqlSession = sqlSessionFactory.openSession();

//        3.执行sql
        //List<User>list =  sqlSession.selectList("test.selectAll");

        //3.1获取UserMapper接口的代理对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User>user = userMapper.selectAll();


        System.out.println(user);

        sqlSession.close();
    }
}
