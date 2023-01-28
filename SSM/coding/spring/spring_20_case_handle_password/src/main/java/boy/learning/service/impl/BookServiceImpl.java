package boy.learning.service.impl;

import boy.learning.dao.BookDao;
import boy.learning.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;


@Service
public class BookServiceImpl implements BookService {

    //5.删除业务层使用new方法创建的Dao对象
    @Autowired
    BookDao bookDao;

    @Override
    public boolean login(String username,String password) {
        return bookDao.login(username, password);
    }
}
