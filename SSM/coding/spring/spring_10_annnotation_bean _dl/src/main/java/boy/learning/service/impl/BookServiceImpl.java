package boy.learning.service.impl;

import boy.learning.dao.BookDao;
import boy.learning.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;


@Component
public class BookServiceImpl implements BookService {


    //是按照属性名称进行装配
    @Autowired
    @Qualifier("bookDao2")
    BookDao bookDao;
    @Override
    public void save() {
        System.out.println("BookServiceImpl is saving");
        bookDao.save();
    }

}
