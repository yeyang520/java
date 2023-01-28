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
    public String save(int id,String name) {

        System.out.println("bookDao is save...");

        System.out.println("id="+id);

        return name;

    }

    public void delete(){
        System.out.println("bookDao is delete...");
    }
    public void update(){
        System.out.println("bookDao is update...");
    }
    public void select(){
        System.out.println("bookDao is select...");
    }

    @Override
    public int selectById() {
        System.out.println("select by id is running...");
        return 100;
    }
}
