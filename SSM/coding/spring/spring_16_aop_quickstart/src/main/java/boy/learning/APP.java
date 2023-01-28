package boy.learning;

import boy.learning.config.SpringConfig;
import boy.learning.dao.BookDao;
import boy.learning.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class APP {
    public static void main(String[] args) {
        //加载配置类
        ApplicationContext  ctx = new AnnotationConfigApplicationContext(SpringConfig.class);

        BookService bookDao = ctx.getBean(BookService.class);

        System.out.println(bookDao);

        System.out.println(bookDao.getClass());

        bookDao.save();

    }
}
