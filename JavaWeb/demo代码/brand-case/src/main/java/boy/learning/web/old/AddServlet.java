package boy.learning.web.old;

import boy.learning.pojo.Brand;
import boy.learning.service.BrandService;
import boy.learning.service.impl.BrandServiceImpl;
import com.alibaba.fastjson.JSON;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

//@WebServlet("/addServlet")
public class AddServlet extends HttpServlet {

    private BrandService brandService = new BrandServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //1.接受数据  json格式提交
        request.setCharacterEncoding("UTF-8");
        BufferedReader bufferedReader = request.getReader();
        String params = bufferedReader.readLine();//json字符串

        //将json字符串转为对象
        Brand brand = JSON.parseObject(params, Brand.class);

        //2.调用service添加
        brandService.add(brand);

        //3.响应成功的标识
        response.getWriter().write("success");


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
