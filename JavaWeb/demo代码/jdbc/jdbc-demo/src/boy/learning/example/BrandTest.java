package boy.learning.example;

import boy.learning.pojo.Brand;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class BrandTest {
    public static void main(String[] args) throws Exception {
//        testSelectAll();
//        testAdd();
//        testUpdate();
        testDelete();
    }


    /**
     * 查询所有
     */
    public static void testSelectAll() throws Exception {
        //1.获取连接对象
            //1.导入jar包
            //2.定义配置文件
            //3.加载配置文件
        Properties prop = new Properties();
        prop.load(new FileInputStream("jdbc-demo/src/druid.properties"));

            //4.获取连接池对象
        DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);

            //5.获取数据库连接
        Connection conn = dataSource.getConnection();
        //2.sql语句
        String sql = "select * from tb_brand";

        //3.PrepareStatement对象
        PreparedStatement pstmt = conn.prepareStatement(sql);

        //4.设置参数

        //5.执行语句
        ResultSet rs = pstmt.executeQuery();

        //6.存放结果
        List<Brand> brands = new ArrayList<Brand>();
        Brand brand = null;
        while(rs.next()){
            //获取数据
            int id = rs.getInt("id");
            String brandName = rs.getString("brand_name");
            String companyName = rs.getString("company_name") ;
            int ordered = rs.getInt("ordered") ;
            String description = rs.getString("description") ;
            Integer status = rs.getInt("status") ;
            //封装对象
            brand = new Brand(id,brandName,companyName,ordered,description,status);

            brands.add(brand);
        }

        System.out.println(brands);

        //7.关闭
        rs.close();
        pstmt.close();
        conn.close();
    }

    /**
     * 添加
     */
    public static void testAdd() throws Exception {
        //接受数据
        String brandName = "香飘飘";
        String companyName = "香飘飘";
        int ordered =  50;
        String description = "描述";
        int status = 0;


        //1.获取连接对象
        //1.导入jar包
        //2.定义配置文件
        //3.加载配置文件
        Properties prop = new Properties();
        prop.load(new FileInputStream("jdbc-demo/src/druid.properties"));

        //4.获取连接池对象
        DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);

        //5.获取数据库连接
        Connection conn = dataSource.getConnection();
        //2.sql语句
        String sql = "insert into tb_brand(brand_name,company_name,ordered,description,status) value (?,?,?,?,?)";

        //3.PrepareStatement对象
        PreparedStatement pstmt = conn.prepareStatement(sql);

        //4.设置参数
        pstmt.setString(1,brandName);
        pstmt.setString(2,companyName);
        pstmt.setInt(3,ordered);
        pstmt.setString(4,description);
        pstmt.setInt(5,status);



        //5.执行语句
        int count = pstmt.executeUpdate();

        //6.存放结果
        System.out.println(count > 0);


        //7.关闭
        pstmt.close();
        conn.close();
    }

    /**
     * 修改
     */
    public static void testUpdate() throws Exception {
        //接受数据
        String brandName = "香飘飘";
        String companyName = "香飘飘";
        int ordered =  1000;
        String description = "绕地球一圈";
        int status = 0;
        int id = 4;


        //1.获取连接对象
        //1.导入jar包
        //2.定义配置文件
        //3.加载配置文件
        Properties prop = new Properties();
        prop.load(new FileInputStream("jdbc-demo/src/druid.properties"));

        //4.获取连接池对象
        DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);

        //5.获取数据库连接
        Connection conn = dataSource.getConnection();
        //2.sql语句
        String sql = "update tb_brand set brand_name = ?, company_name=?, ordered=?,description=?,status=? where id=?";

        //3.PrepareStatement对象
        PreparedStatement pstmt = conn.prepareStatement(sql);

        //4.设置参数
        pstmt.setString(1,brandName);
        pstmt.setString(2,companyName);
        pstmt.setInt(3,ordered);
        pstmt.setString(4,description);
        pstmt.setInt(5,status);
        pstmt.setInt(6,id);



        //5.执行语句
        int count = pstmt.executeUpdate();

        //6.存放结果
        System.out.println(count > 0);


        //7.关闭
        pstmt.close();
        conn.close();
    }


    /**
     * 删除
     */
    public static void testDelete() throws Exception {
        //接受数据

        int id = 4;


        //1.获取连接对象
        //1.导入jar包
        //2.定义配置文件
        //3.加载配置文件
        Properties prop = new Properties();
        prop.load(new FileInputStream("jdbc-demo/src/druid.properties"));

        //4.获取连接池对象
        DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);

        //5.获取数据库连接
        Connection conn = dataSource.getConnection();
        //2.sql语句
        String sql = "delete from tb_brand where id = ?";

        //3.PrepareStatement对象
        PreparedStatement pstmt = conn.prepareStatement(sql);

        //4.设置参数
        pstmt.setInt(1,id);



        //5.执行语句
        int count = pstmt.executeUpdate();

        //6.存放结果
        System.out.println(count > 0);


        //7.关闭
        pstmt.close();
        conn.close();
    }

}
