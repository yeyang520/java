package boy.learning.web.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ContextLoaderListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        //加载资源

    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        //释放资源

    }
}
