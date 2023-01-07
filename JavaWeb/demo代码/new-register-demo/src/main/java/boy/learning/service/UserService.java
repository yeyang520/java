package boy.learning.service;

import boy.learning.mapper.UserMapper;
import boy.learning.pojo.User;
import boy.learning.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class UserService {
    private SqlSessionFactory factory =  SqlSessionFactoryUtils.getSqlSessionFactory();


    /**
     * 登录
     * @param username
     * @param password
     * @return
     */
    public User login(String username,String password){

        //获取sqlsession对象
        SqlSession sqlSession = factory.openSession();

        //获取UserMapper
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        //执行sql语句
        User user = mapper.select(username,password);

        //释放资源
        sqlSession.close();

        return user;
    }


    public boolean register(User user){

        //获取sqlsession
        SqlSession sqlSession = factory.openSession();

        //获取usermapper
        UserMapper map = sqlSession.getMapper(UserMapper.class);

        //注册，判断用户名是否存在
        User u = map.selectByUsername(user.getUsername());

        if(u == null){
            //不存在，注册
            map.add(user);
            sqlSession.commit();
        }
        sqlSession.close();

        return u == null;

    }
}
