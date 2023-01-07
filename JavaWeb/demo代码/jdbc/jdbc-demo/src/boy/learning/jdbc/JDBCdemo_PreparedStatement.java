package boy.learning.jdbc;

import boy.learning.pojo.Account;
import com.sun.javaws.IconUtil;

import java.sql.*;
import java.util.ArrayList;

/*
* JDBC快速入门
* */
public class JDBCdemo_PreparedStatement {
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

        int id = 1;
        int age = 100;

        //定义sql
        String newsql = "select * from stu where id =? and age=?";
        //获取PrepareStatement对象
        PreparedStatement pstmt = conn.prepareStatement(newsql);
        //设置?内容
        pstmt.setInt(1,id);
        pstmt.setInt(2,age);
        //查询
        ResultSet rs =  pstmt.executeQuery();
        while(rs.next()){
            System.out.println(rs.getInt("id"));
            System.out.println(rs.getInt("age"));
        }
    }
}
