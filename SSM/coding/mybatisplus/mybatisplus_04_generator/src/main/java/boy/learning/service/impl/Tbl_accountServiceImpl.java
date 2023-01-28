package boy.learning.service.impl;

import boy.learning.domain.Tbl_account;
import boy.learning.dao.Tbl_accountDao;
import boy.learning.service.ITbl_accountService;
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
public class Tbl_accountServiceImpl extends ServiceImpl<Tbl_accountDao, Tbl_account> implements ITbl_accountService {

}
