package boy.learning.service.impl;

import boy.learning.domain.Emp;
import boy.learning.dao.EmpDao;
import boy.learning.service.IEmpService;
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
public class EmpServiceImpl extends ServiceImpl<EmpDao, Emp> implements IEmpService {

}
