package boy.learning.dao.impl;

import boy.learning.dao.UserDao;

public class UserDaoImpl implements UserDao {
    @Override
    public void save() {
        System.out.println("UserDaoImpl  save ...");
    }
}
