package boy.learning.service.impl;

import boy.learning.domain.Dept;
import boy.learning.dao.DeptDao;
import boy.learning.service.IDeptService;
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
public class DeptServiceImpl extends ServiceImpl<DeptDao, Dept> implements IDeptService {

}
