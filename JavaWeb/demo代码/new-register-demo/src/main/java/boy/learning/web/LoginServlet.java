package boy.learning.web;

import boy.learning.pojo.User;
import boy.learning.service.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {

    private UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取用户名和面膜
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        //获取复选框
        String remember = request.getParameter("remember");

        //调用服务层
        User user = userService.login(username, password);


        //进行判断
        if(user!=null){
            //用户存在

            //判断用户是否点击记住我
            if("1".equals(remember)){
                //发送cookie

                //1。创建Cookie对象
                Cookie c_username = new Cookie("username",username);
                Cookie c_password = new Cookie("password",password);

                //设置Cookie存活时间
                c_username.setMaxAge(60*60*24*1);
                c_password.setMaxAge(60*60*24*1);

                //2.发送Cookie
                response.addCookie(c_username);
                response.addCookie(c_password);
            }


            //将user用户存储到session中
            HttpSession session = request.getSession();
            session.setAttribute("user",user);

            //重定向
            String contextPath = request.getContextPath();
            response.sendRedirect(contextPath+"/selectAllServlet");

        }else {
            //登录失败

            //存储错误信息
            request.setAttribute("login_msg","用户名或密码错误");

            //调跳转login.jsp页面
            request.getRequestDispatcher("/login.jsp").forward(request,response);

        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }
}
