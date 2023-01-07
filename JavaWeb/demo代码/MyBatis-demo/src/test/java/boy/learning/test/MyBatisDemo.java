package boy.learning.test;


import boy.learning.mapper.BrandMapper;
import boy.learning.pojo.Brand;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyBatisDemo {

    @Test
    public void testSelectAll() throws IOException {
        //1.加载MyBatis核心配置文件，获取SqlSessionFactory对象
        String resource = "mybatis-config.xml";
//        传入字符串，返回字节输入流
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2.获取sqlsession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //3.获取mapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        //4.执行对应接口方法
        List<Brand> brands = brandMapper.selectAll();
        System.out.println(brands);

        //5.释放资源
        sqlSession.close();

    }

    /**
     * id 查询
     * @throws IOException
     */
    @Test
    public void testSelectById() throws IOException {
        int id = 1;

        //1.加载MyBatis核心配置文件，获取SqlSessionFactory对象
        String resource = "mybatis-config.xml";
//        传入字符串，返回字节输入流
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2.获取sqlsession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //3.获取mapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        //4.执行对应接口方法
        Brand brand = brandMapper.selectById(id);
        System.out.println(brand);

        //5.释放资源
        sqlSession.close();

    }

    /**
     * 模糊查询
     * @throws IOException
     */
    @Test
    public void testSelectByCondition() throws IOException {
        int status = 1;
        String companyName = "华为";
        String brandName = "华为";
        companyName = "%"+companyName+"%";
        brandName = "%"+brandName+"%";

        //对象
        Brand brand = new Brand();
        brand.setStatus(status);
        brand.setCompanyName(companyName);
        brand.setBrandName(brandName);
        //集合
        Map map = new HashMap();
        map.put("status",status);
        map.put("companyName",companyName);
        map.put("brandName",brandName);


        //1.加载MyBatis核心配置文件，获取SqlSessionFactory对象
        String resource = "mybatis-config.xml";
//        传入字符串，返回字节输入流
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2.获取sqlsession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //3.获取mapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        //4.执行对应接口方法

//        List<Brand> brands = brandMapper.selectByCondition(status,companyName,brandName);
//        List<Brand> brands = brandMapper.selectByCondition(brand);
        List<Brand> brands = brandMapper.selectByConditionSingle(brand);


        System.out.println(brands);

        //5.释放资源
        sqlSession.close();

    }


    /**
     * 添加
     * @throws IOException
     */
    @Test
    public void testAdd() throws IOException {
        int status = 1;
        String companyName = "大军手机";
        String brandName = "大军";
        String descriotion = "大军手机，手机中的战斗机";
        int ordered = 10000;

        //对象
        Brand brand = new Brand();
        brand.setStatus(status);
        brand.setCompanyName(companyName);
        brand.setBrandName(brandName);
        brand.setDescription(descriotion);
        brand.setOrdered(ordered);


        //1.加载MyBatis核心配置文件，获取SqlSessionFactory对象
        String resource = "mybatis-config.xml";
//        传入字符串，返回字节输入流
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2.获取sqlsession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //3.获取mapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        //4.执行对应接口方法

//        List<Brand> brands = brandMapper.selectByCondition(status,companyName,brandName);
//        List<Brand> brands = brandMapper.selectByCondition(brand);
        brandMapper.add(brand);

        List<Brand> brands = brandMapper.selectAll();
        System.out.println(brands);


        //5.释放资源
        sqlSession.close();

    }

    /**
     * 更新
     * @throws IOException
     */
    @Test
    public void testUpdate() throws IOException {
        int status = 1;
        int id = 4;
        String companyName = "大军手机新机型promax";
        String brandName = "小军";
        String descriotion = "大军手机，不只是手机中的战斗机，还是战斗机中的轰炸机";
        int ordered = 10000;

        //对象
        Brand brand = new Brand();
        brand.setStatus(status);
        brand.setCompanyName(companyName);
        brand.setBrandName(brandName);
        brand.setDescription(descriotion);
        brand.setOrdered(ordered);
        brand.setId(id);


        //1.加载MyBatis核心配置文件，获取SqlSessionFactory对象
        String resource = "mybatis-config.xml";
//        传入字符串，返回字节输入流
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2.获取sqlsession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //3.获取mapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        //4.执行对应接口方法

//        List<Brand> brands = brandMapper.selectByCondition(status,companyName,brandName);
//        List<Brand> brands = brandMapper.selectByCondition(brand);
        int a = brandMapper.update(brand);
        System.out.println(a);


        List<Brand> brands = brandMapper.selectAll();
        System.out.println(brands);


        //5.释放资源
        sqlSession.close();

    }

    @Test
    public void testDelete() throws IOException {
        int status = 1;
        int id = 4;
        String companyName = "大军手机新机型promax";
        String brandName = "小军";
        String descriotion = "大军手机，不只是手机中的战斗机，还是战斗机中的轰炸机";
        int ordered = 10000;

        //对象
        Brand brand = new Brand();
        brand.setStatus(status);
        brand.setCompanyName(companyName);
        brand.setBrandName(brandName);
        brand.setDescription(descriotion);
        brand.setOrdered(ordered);
        brand.setId(id);


        //1.加载MyBatis核心配置文件，获取SqlSessionFactory对象
        String resource = "mybatis-config.xml";
//        传入字符串，返回字节输入流
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2.获取sqlsession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //3.获取mapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        //4.执行对应接口方法

//        List<Brand> brands = brandMapper.selectByCondition(status,companyName,brandName);
//        List<Brand> brands = brandMapper.selectByCondition(brand);
        brandMapper.deleteById(id);


        List<Brand> brands = brandMapper.selectAll();
        System.out.println(brands);


        //5.释放资源
        sqlSession.close();

    }

    @Test
    public void testDeleteByIds() throws IOException {
        int []ids = {4};


        //1.加载MyBatis核心配置文件，获取SqlSessionFactory对象
        String resource = "mybatis-config.xml";
//        传入字符串，返回字节输入流
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2.获取sqlsession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //3.获取mapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        //4.执行对应接口方法

//        List<Brand> brands = brandMapper.selectByCondition(status,companyName,brandName);
//        List<Brand> brands = brandMapper.selectByCondition(brand);
        brandMapper.deleteByIds(ids);


        List<Brand> brands = brandMapper.selectAll();
        System.out.println(brands);


        //5.释放资源
        sqlSession.close();

    }

}
