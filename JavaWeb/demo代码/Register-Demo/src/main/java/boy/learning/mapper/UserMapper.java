package boy.learning.mapper;

import boy.learning.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {

    /**
     * 根据用户名和密码登录
     * @param username
     * @param password
     * @return
     */
    @Select("select * from tb_user where username = #{username} and password=#{password}")
    //注解param要跟大括号内的取值一样
    User select(@Param("username")String username,@Param("password")  String password);


    /**
     * 根据用户名查找用户
     * @param username
     * @return
     */
    @Select("select * from tb_user where username=#{username}")
    User selectByUsername(String username);


    /**
     * 添加用户
     * @param user
     */
    @Insert("insert into tb_user values(null,#{username},#{password})")
    void add(User user);
}



