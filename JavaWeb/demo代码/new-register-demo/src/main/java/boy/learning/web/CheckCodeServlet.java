package boy.learning.web;

import boy.learning.util.CheckCodeUtil;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/checkCodeServlet")
public class CheckCodeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //响应输出流，os作为输出流输出图片
        ServletOutputStream os = response.getOutputStream();
        //调用工具类生成图片，得到验证码并输出图片
        String checkCode = CheckCodeUtil.outputVerifyImage(100,50,os,4);

        //存入session
        HttpSession session = request.getSession();
        session.setAttribute("checkCodeGen",checkCode);


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
