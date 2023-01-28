package boy.learning;

import boy.learning.service.impl.BookDaoImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppForCollection {
    public static void main(String[] args) {

        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");

        //4.获取bean
        BookDaoImpl bookDao = (BookDaoImpl)ctx.getBean("bookDao");

        System.out.println("遍历数组："+bookDao.getArray());
        System.out.println("遍历list："+bookDao.getList());
        System.out.println("遍历set："+bookDao.getSet());
        System.out.println("遍历map："+bookDao.getMap());
        System.out.println("遍历propreis："+bookDao.getProperties());
    }

}
