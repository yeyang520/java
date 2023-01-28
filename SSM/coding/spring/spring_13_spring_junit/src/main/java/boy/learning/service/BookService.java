package boy.learning.service;

import boy.learning.domain.Brand;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;


public interface BookService {
    List<Brand> save();
}
