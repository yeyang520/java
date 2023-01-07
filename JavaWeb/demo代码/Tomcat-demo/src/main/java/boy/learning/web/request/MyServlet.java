package boy.learning.web.request;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebServlet(urlPatterns = "/demo2",loadOnStartup = 1)
public class MyServlet implements Servlet{

    /**
     * 初始化方法
     *  1.调用方法：默认情况下，第一次访问时，自动调用
     *      loadOnStartup:设置init调用时间,0正整数，启动时创建
     *  2.调用次数：只调用一次
     * @param servletConfig
     * @throws ServletException
     */
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }


    /**
     * 提供服务
     * 1.调用：每次servlet被访问时，都会调用
     * 2.次数：多次
     * @param servletRequest
     * @param servletResponse
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        //通过请求方式的不同，惊醒分别处理

        HttpServletRequest request = (HttpServletRequest) servletRequest;

        //1.获取亲求方式
        String method = request.getMethod();
        //2.判断
        if("GET".equals(method)){
            //get方式的处理逻辑
            doGet(servletRequest,servletResponse);
        }else if("POST".equals(method)){
            //post方式的处理逻辑
            doPost(servletRequest,servletResponse);
        }
    }

    protected void doPost(ServletRequest servletRequest, ServletResponse servletResponse) {
    }

    protected void doGet(ServletRequest servletRequest, ServletResponse servletResponse) {
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    /**
     * 销毁
     * 1.调用时机：被销毁时，
     *      内存释放或服务器关闭时调用
     * 2.调用次数：1次
     */
    @Override
    public void destroy() {
        System.out.println("destory...");
    }
}
