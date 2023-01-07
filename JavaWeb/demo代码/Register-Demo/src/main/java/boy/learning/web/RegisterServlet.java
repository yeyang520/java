package boy.learning.web;

import boy.learning.mapper.UserMapper;
import boy.learning.pojo.User;
import boy.learning.util.SqlSessionFactoryUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

@WebServlet("/registerServlet")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.获取用户数据
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        //封装用户数据
        User user = new  User();
        user.setUsername(username);
        user.setPassword(password);

        //2.1获取SqlSessionFactory对象
//        String  resorce = "mybatis-config.xml";
//        InputStream inputStream = Resources.getResourceAsStream(resorce);
//        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();

        //2.2获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //2.3获取Mapper
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        //2.4调用方法,查询用户是否存在
        User u = userMapper.selectByUsername(username);

        if(u == null){
            //用户不存在，可以注册
            userMapper.add(user);
            sqlSession.commit();
            sqlSession.close();
        }else {
            //用户存在
            resp.setContentType("text/html;charset=utf-8");
            PrintWriter printWriter = resp.getWriter();
            printWriter.write("用户名已存在!");
        }


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
