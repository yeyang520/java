package boy.learning.web;

import boy.learning.pojo.Brand;
import boy.learning.service.BrandService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleteServlet")
public class DeleteServlet extends HttpServlet {
    private BrandService brandService = new BrandService();


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //处理post乱码问题
        request.setCharacterEncoding("utf-8");

        //接受表单提交的数据，封装为brand对象
        String id = request.getParameter("id");

        //调用service完成添加
        brandService.delete(Integer.parseInt(id));

        //转发到查询所有
        request.getRequestDispatcher("/selectAllServlet").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }
}
