package boy.learning.service.impl;

import boy.learning.mapper.BrandMapper;
import boy.learning.pojo.Brand;
import boy.learning.pojo.PageBean;
import boy.learning.service.BrandService;
import boy.learning.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class BrandServiceImpl implements BrandService {

    //创建SqlSessionFactory工厂对象
    private SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();

    @Override
    public List<Brand> selectAll() {
        //获取sqlsession对象
        SqlSession sqlSession = factory.openSession();
        //获取mapper
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        //调用方法
        List<Brand> brands = mapper.selectAll();

        sqlSession.close();
        return brands;
    }

    @Override
    public void add(Brand brand) {
        //获取sqlsession对象
        SqlSession sqlSession = factory.openSession();
        //获取mapper
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        //调用方法
        mapper.add(brand);


        sqlSession.commit();

        sqlSession.close();
    }

    @Override
    public void deleteByIds(int[] ids) {
        //获取sqlsession对象
        SqlSession sqlSession = factory.openSession();
        //获取mapper
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        //调用方法
        mapper.deleteByIds(ids);

        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public PageBean<Brand> selectByPage(int currentPage, int pageSize) {
        //获取sqlsession对象
        SqlSession sqlSession = factory.openSession();
        //获取mapper
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);


        //计算开始索引
        int begin = (currentPage-1) * pageSize;
        //计算查询条目数
        int size = pageSize;

        //查询当前页数据
        List<Brand> rows = mapper.selectByPage(begin, size);

        //查询总记录数
        int totalCount = mapper.selectTotalCount();

        //封装pageBean对象
        PageBean<Brand> pageBean = new PageBean<>();
        pageBean.setRows(rows);
        pageBean.setTotalCount(totalCount);

        //释放资源
        sqlSession.close();
        return pageBean;
    }

    @Override
    public PageBean<Brand> selectByPageAndCondition(int currentPage, int pageSize, Brand brand) {
        //获取sqlsession对象
        SqlSession sqlSession = factory.openSession();
        //获取mapper
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);


        //计算开始索引
        int begin = (currentPage-1) * pageSize;
        //计算查询条目数
        int size = pageSize;

        //处理brand条件
        String brandName = brand.getbrandName();
        if(brandName!=null && brandName.length() > 0){
            brand.setbrandName("%"+brandName+"%");
        }
        String companyName = brand.getcompanyName();
        if(companyName!=null && companyName.length() > 0){
            brand.setcompanyName("%"+companyName+"%");
        }



        //查询当前页数据
        List<Brand> rows = mapper.selectByPageAndCondition(begin,size,brand);

        //查询总记录数
        int totalCount = mapper.selectTotalCountByCondition(brand);

        //封装pageBean对象
        PageBean<Brand> pageBean = new PageBean<>();
        pageBean.setRows(rows);
        pageBean.setTotalCount(totalCount);

        //释放资源
        sqlSession.close();
        return pageBean;
    }
}
