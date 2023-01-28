package boy.learning.service.impl;

import boy.learning.dao.UserDao;
import boy.learning.domain.Brand;
import boy.learning.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private UserDao userDao;


    @Override
    public List<Brand> save() {
        System.out.println("BookServiceImpl is saving");
        List<Brand> brands = userDao.selectAll();
        return brands;
    }

}
