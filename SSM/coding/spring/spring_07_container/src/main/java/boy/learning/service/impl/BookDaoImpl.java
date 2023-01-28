package boy.learning.service.impl;

import boy.learning.service.BookDao;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class BookDaoImpl implements BookDao {
    private String name;

    public BookDaoImpl() {
        System.out.println("constructor");
    }

    @Override
    public void save() {
        System.out.println("bookDaoImpl is save... "+name);
    }

    public void setName(String name) {
        this.name = name;
    }
}
