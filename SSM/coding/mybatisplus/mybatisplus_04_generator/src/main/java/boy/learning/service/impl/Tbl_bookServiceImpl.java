package boy.learning.service.impl;

import boy.learning.domain.Tbl_book;
import boy.learning.dao.Tbl_bookDao;
import boy.learning.service.ITbl_bookService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 小飞舞
 * @since 2023-01-28
 */
@Service
public class Tbl_bookServiceImpl extends ServiceImpl<Tbl_bookDao, Tbl_book> implements ITbl_bookService {

}
