package boy.learning.service.impl;

import boy.learning.dao.BookDao;
import boy.learning.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class BookServiceImpl implements BookService {

    //5.删除业务层使用new方法创建的Dao对象
    @Autowired
    BookDao bookDao;
    @Override
    public void save() {
//        System.out.println("BookServiceImpl is saving");
//        bookDao.save();
        Long currentTimes = System.currentTimeMillis();
        for(int i=0;i<10000;++i){
            System.out.println("bookDao is save...");
        }
        Long endTimes  = System.currentTimeMillis();

        System.out.println(endTimes - currentTimes+"ms");
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
}
