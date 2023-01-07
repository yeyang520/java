package boy.learning.web.servlet;

import boy.learning.mapper.BrandMapper;
import boy.learning.pojo.Brand;
import boy.learning.pojo.PageBean;
import boy.learning.service.BrandService;
import boy.learning.service.impl.BrandServiceImpl;
import com.alibaba.fastjson.JSON;
import org.apache.ibatis.session.SqlSession;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

@WebServlet("/brand/*")
public class BrandServlet extends BaseServlet{

    private BrandService brandService = new BrandServiceImpl();


    /**
     * 查询所有
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    public void selectAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        //调用查询
        List<Brand> brands = brandService.selectAll();
        //将数据转为json
        String jsonString = JSON.toJSONString(brands);
        //写数据
        resp.setContentType("text/json;charset=utf-8");
        resp.getWriter().write(jsonString);
    }

    public void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        //1.接受数据  json格式提交
        req.setCharacterEncoding("UTF-8");
        BufferedReader bufferedReader = req.getReader();
        String params = bufferedReader.readLine();//json字符串

        //将json字符串转为对象
        Brand brand = JSON.parseObject(params, Brand.class);

        //2.调用service添加
        brandService.add(brand);

        //3.响应成功的标识
        resp.getWriter().write("success");
    }


    /**
     * 批量删除
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    public void deleteByIds(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        //1.接受数据  json格式提交
//        req.setCharacterEncoding("UTF-8");
        BufferedReader bufferedReader = req.getReader();
        String params = bufferedReader.readLine();//json字符串

        //将json字符串转为int数组
        int[] ids = JSON.parseObject(params, int[].class);

        //2.调用service删除
        brandService.deleteByIds(ids);

        //3.响应成功的标识
        resp.getWriter().write("success");
    }


    /**
     * 分页查询
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    public void selectByPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{

        //接受参数,当前页码和显示条数  url?currentPage=1&pageSize=5
        String _currentPage = req.getParameter("currentPage");
        String _pageSize = req.getParameter("pageSize");
        int currentPage = Integer.parseInt(_currentPage);
        int pageSize = Integer.parseInt(_pageSize);


        //调用分页查询
        PageBean<Brand> pageBean = brandService.selectByPage(currentPage,pageSize);
        //将数据转为json
        String jsonString = JSON.toJSONString(pageBean);
        //写数据
        resp.setContentType("text/json;charset=utf-8");
        resp.getWriter().write(jsonString);
    }


    /**
     * 分页条件查询
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    public void selectByPageAndCondition(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{

        //接受参数,当前页码和显示条数  url?currentPage=1&pageSize=5
        String _currentPage = req.getParameter("currentPage");
        String _pageSize = req.getParameter("pageSize");
        int currentPage = Integer.parseInt(_currentPage);
        int pageSize = Integer.parseInt(_pageSize);

        //获取查询条件对象
            //1.接受数据  json格式提交
//        req.setCharacterEncoding("UTF-8");
        BufferedReader bufferedReader = req.getReader();
        String params = bufferedReader.readLine();//json字符串

        //将json字符串转为Brand对象
        Brand brand = JSON.parseObject(params, Brand.class);



        //调用分页查询
        PageBean<Brand> pageBean = brandService.selectByPageAndCondition(currentPage,pageSize,brand);
        //将数据转为json
        String jsonString = JSON.toJSONString(pageBean);
        //写数据
        resp.setContentType("text/json;charset=utf-8");
        resp.getWriter().write(jsonString);
    }



}
