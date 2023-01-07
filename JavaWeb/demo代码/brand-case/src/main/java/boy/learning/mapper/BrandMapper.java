package boy.learning.mapper;


import boy.learning.pojo.Brand;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface BrandMapper {

    /**
     * 查询所有
     * @return
     */
    @Select("select * from tb_brand")
    @ResultMap("brandResultMap")
    List<Brand> selectAll();


    /**
     * 新增品牌
     * @param brand
     */
    @Insert("insert into tb_brand values(null,#{brandName},#{companyName},#{ordered},#{description},#{status})")

    void add(Brand brand);

    /**
     * 修改
     * @param brand
     */
    @Update("update tb_brand set brand_name = #{brandName},company_name = #{companyName},ordered = #{ordered},descroption = #{description},status = #{status} where id = #{id}")
    void uopdate(Brand brand);


    /**
     * 批量删除
     * @param ids
     */
    void deleteByIds(@Param("ids") int[] ids);


    /**
     * 分页查询
     * @param begin
     * @param size
     * @return
     */
    @Select("select * from tb_brand limit #{begin} , #{size}")
    @ResultMap("brandResultMap")
    List<Brand> selectByPage(@Param("begin") int begin,@Param("size")int size);


    /**
     * 查询总记录数
     * @return
     */
    @Select("select count(*) from tb_brand")
    int selectTotalCount();


    /**
     * 分页条件查询
     * @param begin
     * @param size
     * @param brand
     * @return
     */
    List<Brand> selectByPageAndCondition(@Param("begin") int begin,@Param("size")int size,@Param("brand") Brand brand);


    /**
     * 查询总记录数根据条件
     * @return
     */
    int selectTotalCountByCondition(Brand brand);

}
