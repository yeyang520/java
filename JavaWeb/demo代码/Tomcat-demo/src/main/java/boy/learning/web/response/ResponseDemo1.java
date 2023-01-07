package boy.learning.web.response;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/resp1")
public class ResponseDemo1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("resp1...");

        //重定向
        //1.设置响应状态码
        response.setStatus(302);
        //2.设置响应头
        //动态获取虚拟目录
        String contextPath = request.getContextPath();
        response.setHeader("location","/Tomcat-demo/resp2");

        //简化方式
        response.sendRedirect(contextPath+"/resp2");


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
