package boy.learning;

import boy.learning.config.SpringConfig;
import boy.learning.domain.Brand;
import boy.learning.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class App2 {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);

        BookService bookService = ctx.getBean(BookService.class);
        List<Brand> brands = bookService.save();
        System.out.println(brands);

    }
}
