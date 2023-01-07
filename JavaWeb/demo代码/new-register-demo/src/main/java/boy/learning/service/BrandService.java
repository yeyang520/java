package boy.learning.service;

import boy.learning.mapper.BrandMapper;
import boy.learning.pojo.Brand;
import boy.learning.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class BrandService {
    SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();

    /**
     * 查询所有功能
     * @return
     */
    public List<Brand> selectAll(){
        //调用BrandMapper.selectAll()

        //获取sqlsession对象
        SqlSession sqlSession = factory.openSession();

        //获取mapper对象
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        //调用方法
        List<Brand> brands = mapper.selectAll();

        sqlSession.close();

        return brands;
    }

    /**
     * 添加
     * @param brand
     */
    public void add(Brand brand){
        //调用BrandMapper.selectAll()

        //获取sqlsession对象
        SqlSession sqlSession = factory.openSession();

        //获取mapper对象
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        //调用
        mapper.add(brand);

        //提交事务
        sqlSession.commit();

        //释放资源
        sqlSession.close();
    }


    /**
     * 根据id查询
     * @return
     */
    public Brand selectById(int id){
        //调用BrandMapper.selectAll()

        //获取sqlsession对象
        SqlSession sqlSession = factory.openSession();

        //获取mapper对象
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        //调用方法
        Brand brand = mapper.selectById(id);

        sqlSession.close();

        return brand;
    }

    /**
     * 修改
     * @param brand
     */
    public void update(Brand brand){
        //调用BrandMapper.selectAll()

        //获取sqlsession对象
        SqlSession sqlSession = factory.openSession();

        //获取mapper对象
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        //调用
        mapper.update(brand);

        //提交事务
        sqlSession.commit();

        //释放资源
        sqlSession.close();
    }


    /**
     * 删除
     * @param id
     */
    public void delete(int id){
        //调用BrandMapper.selectAll()

        //获取sqlsession对象
        SqlSession sqlSession = factory.openSession();

        //获取mapper对象
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        //调用
        mapper.delete(id);

        //提交事务
        sqlSession.commit();

        //释放资源
        sqlSession.close();
    }
}
