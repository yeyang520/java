package boy.learning.dao.impl;

import boy.learning.dao.BookDao;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;


@Component("bookDao")
@Scope("singleton")
public class BookDaoImpl implements BookDao {
    @Override
    public void save() {
        System.out.println("BookDaoImpl is saving");
    }


    @PostConstruct
    public void init() {
        System.out.println("BookDaoImpl is init");
    }


    @PreDestroy
    public void destory() {
        System.out.println("BookDaoImpl is destory");
    }
}
