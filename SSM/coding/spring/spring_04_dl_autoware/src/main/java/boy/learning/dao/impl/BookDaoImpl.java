package boy.learning.dao.impl;

import boy.learning.dao.BookDao;

public class BookDaoImpl implements BookDao {
    @Override
    public void save() {
        System.out.println("BookDaoImpl is saving");
    }

    public void init(){
        System.out.println("init ...");
    }

    public void destory(){
        System.out.println("destory ...");
    }


}
