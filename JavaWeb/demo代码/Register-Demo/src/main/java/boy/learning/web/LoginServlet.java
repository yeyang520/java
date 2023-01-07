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

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.接受用户名和密码
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        //2.调用MyBatis完成查询


        //2.1获取SqlSessionFactory对象
//        String  resorce = "mybatis-config.xml";
//        InputStream inputStream = Resources.getResourceAsStream(resorce);
//        SqlSessionFactory  sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();


        //2.2获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //2.3获取Mapper
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        //2.4调用方法
        User user = userMapper.select(username,password);
        //2.5释放资源
        sqlSession.close();


        //获取对应的字符输出流，并设置content-type
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter printWriter = resp.getWriter();
        //3.判断user是否为null
        if(user!=null){
            //登录成功
            printWriter.write("登录成功！");
        }else {
            //登录失败
            printWriter.write("登录失败！");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
