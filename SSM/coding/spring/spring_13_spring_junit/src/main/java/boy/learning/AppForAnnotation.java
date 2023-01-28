package boy.learning;


import boy.learning.dao.UserDao;
import boy.learning.domain.Brand;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;


public class AppForAnnotation {
    public static void main(String[] args) throws IOException {
        //        1.加载MyBatis核心配置文件，获取SqlSessionFactory对象
        String resource = "mybatis-config.xml.bak";
        //        传入字符串，返回字节输入流
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //        2.获取SqlSession对象，用来执行sql
        SqlSession sqlSession = sqlSessionFactory.openSession();

        UserDao mapper = sqlSession.getMapper(UserDao.class);

        List<Brand> brands = mapper.selectAll();

        System.out.println(brands);

        sqlSession.close();

    }
}
