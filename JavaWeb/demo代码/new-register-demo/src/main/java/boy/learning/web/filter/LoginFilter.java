package boy.learning.web.filter;


import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;


/**
 * 登录验证的过滤器
 */
@WebFilter("/*")
public class LoginFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        //强转
        HttpServletRequest req = (HttpServletRequest)request;
        
        //判断访问路径是否和登录注册相关
        String[] urls = {"/login.jsp","/css/","/image/","/loginServlet","register.jsp","/registerServlet","/checkCodeServlet"};
        //获取当前访问路径
        String url = req.getRequestURI().toString();

        //循环判断
        for (String u : urls) {
            if(url.contains(u)){
                //找到啦，放行
                chain.doFilter(request, response);
                //break;
                return;
            }
        }


        //判断session中是否有user
        HttpSession session = req.getSession();
        Object user = session.getAttribute("user");


        //判断是否为null
        if(user != null){
            //登录过了
            //放行
            chain.doFilter(request, response);
        } else {
            //没有登录
            req.setAttribute("login_msg","您尚未登录");
            req.getRequestDispatcher("/login.jsp").forward(req,response);
        }



    }
}
