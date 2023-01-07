package boy.learning.web.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


/**
 * 实现HttpServlet，根据请求的最后一段路径进行方法分发
 */

public class BaseServlet extends HttpServlet {


    //根据资源路径进行方法分发
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.获取请求路径
        String uri = req.getRequestURI(); //   /brand-case/brand/selectAll

        //2.获取最后一段路径方法名
        int index = uri.lastIndexOf('/');
        String methodName = uri.substring(index+1); //   selectAll

        //3.获取对象
            //1.获取BrandServlet对象的字节码对象Class
            //谁调用我（this所在的方法） 我（this）代表谁  BrandServlet!
        Class<? extends BaseServlet> cls = this.getClass();

        //2.获得method方法
        try {
            Method method = cls.getMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);

            //3.执行方法
            method.invoke(this,req,resp);

        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
