package boy.learning.mapper;

import boy.learning.pojo.Brand;
import boy.learning.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface BrandMapper {

    /**
     * 查询所有
     * @return
     */
    List<Brand> selectAll();

    /**
     * 查看详情
     */
    Brand selectById(int id);

    /**
     * 条件查询
     *  1.散装参数  @Param("")
     *  2.对象参数  对象名称要和参数占位符名称一致
     *  3.map集合参数
     * @param status
     * @param companyName
     * @param brandName
     * @return
     */
    List<Brand> selectByCondition(@Param("status")int status, @Param("companyName")String companyName,@Param("brandName")String brandName);

    List<Brand> selectByCondition(Brand brand);
    List<Brand> selectByCondition(Map map);

    /**
     * 但条件动态查询
     * @param brand
     * @return
     */
    List<Brand> selectByConditionSingle(Brand brand);

    /**
     * 添加
     * @param brand
     */
    void add(Brand brand);

    /**
     * 修改
     * @param brand
     * @return
     */
    int update(Brand brand);

    /**
     * 删除
     * @param id
     */
    void deleteById(int id);

    /**
     * 批量删除
     * @param ids
     */
    void deleteByIds(@Param("ids")int[] ids);
}
