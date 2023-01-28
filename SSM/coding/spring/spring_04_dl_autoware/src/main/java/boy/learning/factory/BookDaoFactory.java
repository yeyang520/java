package boy.learning.factory;

import boy.learning.dao.BookDao;
import boy.learning.dao.impl.BookDaoImpl;

public class BookDaoFactory {
    //静态
    private static BookDao bookDaoImpl = new BookDaoImpl();
    public static BookDao getBookDao(){
        return bookDaoImpl;
    }

}
