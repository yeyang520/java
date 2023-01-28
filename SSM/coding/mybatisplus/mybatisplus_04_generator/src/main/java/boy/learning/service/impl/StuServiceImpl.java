package boy.learning.service.impl;

import boy.learning.domain.Stu;
import boy.learning.dao.StuDao;
import boy.learning.service.IStuService;
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
public class StuServiceImpl extends ServiceImpl<StuDao, Stu> implements IStuService {

}
