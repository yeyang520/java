package boy.learning.service.impl;

import boy.learning.domain.Job;
import boy.learning.dao.JobDao;
import boy.learning.service.IJobService;
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
public class JobServiceImpl extends ServiceImpl<JobDao, Job> implements IJobService {

}
