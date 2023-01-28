package boy.learning;

import boy.learning.dao.BookDao;
import boy.learning.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App2 {

    public static void main(String[] args) {

        //3.获取IoC容器
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");

        //4.获取bean
        BookDao bookDao = (BookDao)ctx.getBean("bookDao");

        BookService bookService = ctx.getBean(BookService.class);//按类型访问

        bookDao.save();
        bookService.save();


    }
    


}
