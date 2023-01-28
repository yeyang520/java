package boy.learning.service.impl;

import boy.learning.dao.BookDao;
import boy.learning.dao.UserDao;
import boy.learning.service.BookService;

public class BookServiceImpl implements BookService {

    //5.删除业务层使用new方法创建的Dao对象
    BookDao bookDao;
    UserDao userDao;

    public BookServiceImpl(BookDao bookDao, UserDao userDao) {
        this.bookDao = bookDao;
        this.userDao = userDao;
    }

    @Override
    public void save() {
        System.out.println("BookServiceImpl is saving");
        bookDao.save();
        userDao.save();
    }

    //6.提供对应的set方法
//    public void setBookDao(BookDao bookDao) {
//        this.bookDao = bookDao;
//    }

//    public void setUserDao(UserDao userDao) {
//        this.userDao = userDao;
//    }
}
