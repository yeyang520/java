package boy.learning.web;

import boy.learning.pojo.Brand;
import boy.learning.service.BrandService;
import com.alibaba.fastjson2.JSON;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.BufferedReader;
import java.io.IOException;

@WebServlet("/addServlet")
public class AddServlet extends HttpServlet {

    private BrandService service = new BrandService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //request.getParameter()不能接受json数据


        //1.获取请求体数据
        request.setCharacterEncoding("UTF-8");
        BufferedReader br = request.getReader();
        String params = br.readLine();

        //2.将js字符转换为java对像
        Brand brand = JSON.parseObject(params, Brand.class);
        System.out.println(brand);

        //3.调用service添加
        service.add(brand);

        //4.响应成功标识
        response.getWriter().write("success");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
