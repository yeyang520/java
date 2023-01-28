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

        //4.获取bean
        BookDao bookDao = (BookDao)ctx.getBean("bookDao");
        BookService bookService = (BookService) ctx.getBean("bookService");

        bookDao.save();
        bookService.save();

        System.out.println("---------");

        //方式二：工厂创建
        BookDao bookDao1 = BookDaoFactory.getBookDao();
        bookDao1.save();


        System.out.println("-------------");

        //方式三：实例化工厂
//        UserDaoFactory userDaoFactory = new UserDaoFactory();
//        UserDao userDao = userDaoFactory.getUserDao();
//        userDao.save();
        UserDao userDao = (UserDao) ctx.getBean("userDao");
        userDao.save();


    }
    


}
