package boy.learning.service.impl;

import boy.learning.controller.Code;
import boy.learning.dao.BookDao;
import boy.learning.domain.Book;
import boy.learning.exception.SystemException;
import boy.learning.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDao bookDao;


    @Override
    public boolean save(Book book) {
        return bookDao.save(book) > 0;
    }

    @Override
    public boolean update(Book book) {
        return bookDao.update(book) > 0;
    }

    @Override
    public boolean delete(Integer id) {
        return bookDao.delete(id) > 0;
    }

    @Override
    public Book getById(Integer id) {
        //将可能出现的异常转化为自定义异常
        try {
//            int i =  1/0;
        } catch (ArithmeticException e) {
            throw new SystemException(Code.SYSTEM_ERR,"服务器访问超时，请重试",e);
        }

        return bookDao.getById(id);
    }

    @Override
    public List<Book> getAll() {
        return bookDao.getAll();
    }
}
