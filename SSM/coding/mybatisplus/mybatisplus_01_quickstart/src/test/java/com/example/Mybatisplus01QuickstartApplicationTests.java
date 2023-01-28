package com.example;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.dao.UserDao;
import com.example.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class Mybatisplus01QuickstartApplicationTests {

    @Autowired
    private UserDao userDao;

    @Test
    void testSave(){
        User user = new User();
        user.setId(null);
        user.setName("大傻逼");
        user.setType("666");
        user.setDescription("你来呀");
        userDao.insert(user);
    }

    @Test
    void testUpdate(){
        User user = new User();
        user.setId(2);
        user.setName("大傻逼666");
        userDao.updateById(user);
    }


    @Test
    void testGetAll() {
        //方式一：按条件查询
        QueryWrapper qw = new QueryWrapper();
        //查询id小于10的所有
        qw.lt("id",10);
        List<User> users = userDao.selectList(qw);
        System.out.println(users);

        //方式二：Lambda
        QueryWrapper<User> qw2 = new QueryWrapper();
        //查询id小于10的所有
        qw2.lambda().lt(User::getId,10);
        List<User> users2 = userDao.selectList(qw);
        System.out.println(users2);


        //方式三：Lambda格式条件查询
        LambdaQueryWrapper<User> lqw = new LambdaQueryWrapper<>();
        //id为8到10之间
        lqw.lt(User::getId,10);
        lqw.gt(User::getId,8);
        //小于8或者大于10
        lqw.lt(User::getId,8).or().gt(User::getId,10);

        List<User> users3 = userDao.selectList(lqw);
        System.out.println(users3);
    }


    @Test
    void testGetByPage(){
        IPage page = new Page(1,2);
        IPage p = userDao.selectPage(page, null);
        System.out.println("当前页码值"+page.getCurrent());
        System.out.println("一共多少页"+page.getPages());
        System.out.println("每页显示条数"+page.getSize());
        System.out.println("总条数"+page.getTotal());
        System.out.println("数据"+page.getRecords());
    }

}
