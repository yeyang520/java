package boy.learning;

import boy.learning.config.SpringConfig;
import boy.learning.dao.BookDao;
import boy.learning.service.BookService;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppForAnnotation {
    public static void main(String[] args) {
        //加载配置类
        AnnotationConfigApplicationContext  ctx = new AnnotationConfigApplicationContext(SpringConfig.class);


        BookService bookService = ctx.getBean(BookService.class);

        bookService.save();

        ctx.close();

    }
}
