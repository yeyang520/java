package boy.learning.dao.impl;

import boy.learning.dao.BookDao;
import org.springframework.stereotype.Component;


@Component("bookDao")
public class BookDaoImpl implements BookDao {
    @Override
    public void save() {
        System.out.println("BookDaoImpl is saving");
    }
}
