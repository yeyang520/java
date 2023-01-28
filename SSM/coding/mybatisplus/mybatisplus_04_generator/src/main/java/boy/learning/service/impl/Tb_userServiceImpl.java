package boy.learning.service.impl;

import boy.learning.domain.Tb_user;
import boy.learning.dao.Tb_userDao;
import boy.learning.service.ITb_userService;
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
public class Tb_userServiceImpl extends ServiceImpl<Tb_userDao, Tb_user> implements ITb_userService {

}
