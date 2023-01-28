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
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");

        BookService bookService = (BookService) ctx.getBean("bookService");

        bookService.save();

        System.out.println("---------");



    }
    


}
