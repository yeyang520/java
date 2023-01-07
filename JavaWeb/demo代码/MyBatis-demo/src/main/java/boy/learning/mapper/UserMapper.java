package boy.learning.mapper;

import boy.learning.pojo.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper {

    List<User> selectAll();

    @Select("select * from stu where id = #{id}")
    User selectbyId(int id);


}
