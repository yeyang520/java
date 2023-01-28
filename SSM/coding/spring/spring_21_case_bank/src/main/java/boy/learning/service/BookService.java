package boy.learning.service;

import boy.learning.domain.Brand;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.List;


public interface BookService {

    //只读，什么异常回滚
    @Transactional(readOnly = true,rollbackFor = {IOException.class})
    List<Brand> save();
}
