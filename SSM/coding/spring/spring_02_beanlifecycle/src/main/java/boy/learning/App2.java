package boy.learning;

import boy.learning.dao.BookDao;
import boy.learning.dao.UserDao;
import boy.learning.factory.BookDaoFactory;
import boy.learning.factory.UserDaoFactory;
import boy.learning.service.BookService;
import boy.learning.service.impl.BookServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App2 {

    public static void main(String[] args) {

        //3.获取IoC容器
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");

//        ctx.registerShutdownHook();


        //4.获取bean
        BookDao bookDao = (BookDao)ctx.getBean("bookDao");
        BookService bookService = (BookService) ctx.getBean("bookService");

        bookDao.save();
        bookService.save();

        ctx.close();




    }
    


}
