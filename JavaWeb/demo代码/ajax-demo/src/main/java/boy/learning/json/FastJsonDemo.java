package boy.learning.json;

import boy.learning.pojo.User;
import com.alibaba.fastjson.JSON;

public class FastJsonDemo {
    public static void main(String[] args) {

        //1.将java对象转为json
        User user = new User();
        user.setId(1);
        user.setUsername("zhangsan");
        user.setPassword("123");

        String jsonString = JSON.toJSONString(user);
        System.out.println(jsonString);


        //2.将json字符串转为java对象
        User u = JSON.parseObject("{\"id\":1,\"password\":\"123\",\"username\":\"zhangsan\"}", User.class);
        System.out.println(u);

    }
}
