package boy.learning;

import boy.learning.dao.BookDao;
import boy.learning.domain.Book;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@MapperScan({"boy.learning.dao"})
class Sproing07MybatisApplicationTests {

    @Autowired
    private BookDao bookDao;

    @Test
    void testById() {
        Book book = bookDao.getById(3);
        System.out.println(book);
    }

}
