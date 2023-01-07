package boy.learning.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/*
* JDBC快速入门
* */
public class JDBCdemo_statement {
    public static void main(String [] args) throws Exception{
        testDML();
    }


    public static void testDML() throws SQLException {
        //1. 注册驱动
//        Class.forName("com.mysql.jdbc.Driver");

        //2. 获取连接 如果连接本机 并且端口吗默认3306
        String url = "jdbc:mysql:///db1?useSSL=false";//本地连接
        String username = "root";
        String password = "123456";
        Connection conn  = DriverManager.getConnection(url,username,password);
        //定义sql语句
        String sql1 = "update stu set age = 100 where id = 1";
        String sql2 = "update stu set age = 100 where id = 2";
        //4.获取执行的对象 Statement
        Statement stmt = conn.createStatement();
        try {
            //开启事务
            conn.setAutoCommit(false);
            //5.执行sql
            int count1 = stmt.executeUpdate(sql1);//受影响函数的返回值
            int count2 = stmt.executeUpdate(sql2);

            //6.处理结果
            System.out.println(count1+" "+count2);
        } catch (Exception e) {
            //回滚事务
            conn.rollback();
            throw new RuntimeException(e);
        }
        //7.释放资源
        stmt.close();
        conn.close();
    }

}
