package boy.learning.service.impl;

import boy.learning.dao.BookDao;
import boy.learning.service.BookService;
import javafx.fxml.Initializable;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;


public class BookServiceImpl implements BookService , InitializingBean, DisposableBean {

    //5.删除业务层使用new方法创建的Dao对象
    BookDao bookDao2;
    @Override
    public void save() {
        System.out.println("BookServiceImpl is saving");
        bookDao2.save();
    }

    //6.提供对应的set方法
    public void setBookDao(BookDao bookDao) {
        this.bookDao2 = bookDao;
    }


    @Override
    public void destroy() throws Exception {
        System.out.println("serivce destory ...");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("service init...");
    }
}
