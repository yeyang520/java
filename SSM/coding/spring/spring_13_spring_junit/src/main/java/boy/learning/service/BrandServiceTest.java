package boy.learning.service;

import boy.learning.config.SpringConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

//设定类运行器,Spring整和junit的专用类运行器
@RunWith(SpringJUnit4ClassRunner.class)

@ContextConfiguration(classes = SpringConfig.class)
public class BrandServiceTest {

    @Autowired
    BookService bookService;

    @Test
    public void findAll(){
        System.out.println(bookService.save());
    }
}
