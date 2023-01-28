package boy.learning.dao.impl;

import boy.learning.dao.BookDao;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;


@Repository
public class BookDaoImpl implements BookDao {
    @Override
    public boolean login(String username, String password) {
        return password.equals("root");
    }
}
