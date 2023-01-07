package boy.learning.web;

import boy.learning.pojo.User;
import boy.learning.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/registerServlet")
public class RegisterServlet extends HttpServlet {

    private UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取用户名和面膜
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        User user = new User();
        user.setUsername(username);
        user.setPassword(password);

        //获取用户输入的验证码
        String checkCode = request.getParameter("checkCode");
        //获取程序生成的验证码
        HttpSession session = request.getSession();
        String checkCodeGen = (String)session.getAttribute("checkCodeGen");


        //比对验证码,不分大小写
        if(!checkCodeGen.equalsIgnoreCase(checkCode)){
            //跳转到登录界面
            request.setAttribute("register_msg","验证码错误");
            //转发
            request.getRequestDispatcher("/register.jsp").forward(request,response);
            //不一样，不允许注册
            return;
        }



        //调用服务层servlet注册
        boolean falg = userService.register(user);


        //进行判断
        if(falg){

            //跳转到登录界面
            request.setAttribute("register_msg","注册成功，请登录");

            //转发
            request.getRequestDispatcher("/login.jsp").forward(request,response);

        }else {
            //注册失败
            request.setAttribute("register_msg","用户名已存在");

            //转发
            request.getRequestDispatcher("/register.jsp").forward(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }
}
