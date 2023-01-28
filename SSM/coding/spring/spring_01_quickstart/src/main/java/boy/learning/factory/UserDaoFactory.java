package boy.learning.factory;

import boy.learning.dao.UserDao;
import boy.learning.dao.impl.UserDaoImpl;

public class UserDaoFactory {
    //非静态
    public UserDao getUserDao(){
        return new UserDaoImpl();
    }
}
