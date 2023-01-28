package boy.learning.factory;


import boy.learning.dao.UserDao;
import boy.learning.dao.impl.UserDaoImpl;
import org.springframework.beans.factory.FactoryBean;

public class UserDaoFactoryBean implements FactoryBean<UserDao> {

    //代替原厂实例工厂中创建对象方法
    @Override
    public UserDao getObject() throws Exception {
        return new UserDaoImpl();
    }


    //对象什么类型
    @Override
    public Class<?> getObjectType() {
        return UserDao.class;
    }


    //是否单例
    @Override
    public boolean isSingleton() {
        return FactoryBean.super.isSingleton();
    }
}
