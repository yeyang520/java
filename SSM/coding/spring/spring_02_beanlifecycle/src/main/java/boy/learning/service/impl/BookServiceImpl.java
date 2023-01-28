package boy.learning.service.impl;

import boy.learning.dao.BookDao;
import boy.learning.service.BookService;
import javafx.fxml.Initializable;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import java.net.URL;
import java.util.ResourceBundle;

public class BookServiceImpl implements BookService , InitializingBean, DisposableBean {

    //5.删除业务层使用new方法创建的Dao对象
    BookDao bookDao;
    @Override
    public void save() {
        System.out.println("BookServiceImpl is saving");
        bookDao.save();
    }

    //6.提供对应的set方法
    public void setBookDao(BookDao bookDao) {
        this.bookDao = bookDao;
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
