package boy.learning.jdbc;

import boy.learning.pojo.Account;

import java.sql.*;
import java.util.ArrayList;

/*
* JDBC快速入门
* */
public class JDBCdemo {
    /**
     * 查询stu表，封装进account对象，存入ArrayList中
     * @param args
     * @throws Exception
     */
    public static void main(String [] args) throws Exception{
        //1. 注册驱动
//        Class.forName("com.mysql.jdbc.Driver");

        //2. 获取连接 如果连接本机 并且端口吗默认3306
        String url = "jdbc:mysql:///db1?useSSL=false";//本地连接
        String username = "root";
        String password = "123456";
        Connection conn  = DriverManager.getConnection(url,username,password);

        //定义sql语句
        String sql = "select * from stu";

        //4.获取对象
        Statement stat = conn.createStatement();

        //5.执行
        ResultSet rs = stat.executeQuery(sql);

        //创建集合
        ArrayList<Account> list = new ArrayList<Account>();

        //6.处理完，遍历数据
        while(rs.next()){
            Account account = new Account();

            int id = rs.getInt("id");
            String name = rs.getString("name");
            int age = rs.getInt("age");

            account.setId(id);
            account.setName(name);
            account.setAge(age);

            list.add(account);
        }

        System.out.println(list);

        //7.释放资源
        stat.close();
        conn.close();
        String name = "asfjasklfjaslf";
        String pwd = "' or '1'='1";

        String newsql = "select * from tb_user where username = '"+name+"'and password = '"+pwd+"'";
        System.out.println(newsql);
    }
}
