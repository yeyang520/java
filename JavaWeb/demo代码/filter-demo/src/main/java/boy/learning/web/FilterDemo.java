package boy.learning.web;


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter("/*")
public class FilterDemo implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {


    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("1.FilterDemo...");

        //放行
        filterChain.doFilter(servletRequest,servletResponse);

        System.out.println("5.FilterDemo...");
    }

    @Override
    public void destroy() {

    }
}
