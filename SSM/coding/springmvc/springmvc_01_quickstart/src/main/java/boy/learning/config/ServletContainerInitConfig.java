package boy.learning.config;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.support.AbstractDispatcherServletInitializer;

//4.定义一个Servlet容器启动的配置类，在里面加载Spring配置
public class ServletContainerInitConfig extends AbstractDispatcherServletInitializer {


    //加载SpringMVC容器配置
    @Override
    protected WebApplicationContext createServletApplicationContext() {
        AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
        ctx.register(SpringMvcConfig.class);
        return ctx;
    }

    //设置那些请求归属SpringMVC容器处理
    @Override
    protected String[] getServletMappings() {
        //所有请求归MVC处理
        return new String[]{"/"};
    }


    //加载Spring容器的配置
    @Override
    protected WebApplicationContext createRootApplicationContext() {
        return null;
    }
}
