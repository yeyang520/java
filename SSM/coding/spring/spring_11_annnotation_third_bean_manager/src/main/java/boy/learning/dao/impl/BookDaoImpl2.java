package boy.learning.dao.impl;

import boy.learning.dao.BookDao;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;


@Component("bookDao2")
@Scope("singleton")
public class BookDaoImpl2 implements BookDao {

    @Value("${name}")
    private String name;

    @Override
    public void save() {
        System.out.println("BookDaoImpl is saving 2  "+ name);
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
