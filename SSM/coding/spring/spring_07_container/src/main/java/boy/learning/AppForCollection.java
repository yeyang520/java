package boy.learning;

import boy.learning.service.BookDao;
import boy.learning.service.impl.BookDaoImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import javax.sql.DataSource;

public class AppForCollection {
    public static void main(String[] args) {

        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");

        ApplicationContext ctx2 = new FileSystemXmlApplicationContext("D:\\working\\Java\\SSM\\coding\\spring_07_container\\src\\main\\resources\\applicationContext.xml");

//        BookDao bookDao1 = ctx.getBean(BookDao.class);
//
//        BookDao bookDao2 = (BookDao) ctx.getBean("bookDao");
//
//        BookDao bookDao3 = ctx.getBean("bookDao",BookDao.class);
//
//        bookDao1.save();



    }

}
