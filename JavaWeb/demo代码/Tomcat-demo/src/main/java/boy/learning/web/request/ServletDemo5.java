package boy.learning.web.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Map;


public class ServletDemo5 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");

        //get请求逻辑
        System.out.println("get...");

        //1.获取所有参数的map集合
        Map<String,String[]> map = req.getParameterMap();
        for (String key : map.keySet()) {

            //username:zhangsan lisi
            System.out.print(key+":");

            //获取值
            String[] values = map.get(key);
            for (String value : values) {
                System.out.print(value+" ");
            }
            System.out.println();
        }


        //2.获取参数值，数组
        String[] hobbies = req.getParameterValues("hobby");

        for (String hobby : hobbies) {
            System.out.print(hobby+" ");
        }
        System.out.println();

        //3.根据key获取单个参数值
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String newHobby = req.getParameter("hobby");
        //将获取到的中文先编码后解码为utf-8
        username = new String(username.getBytes(StandardCharsets.ISO_8859_1),StandardCharsets.UTF_8);

        System.out.println(newHobby);
        System.out.println(username);
        System.out.println(password);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("post...");

        req.setCharacterEncoding("UTF-8");
        this.doGet(req,resp);
        //获取请求体
        //1.获取字符输入流
        BufferedReader br = req.getReader();
        String line = br.readLine();
        System.out.println(line);
    }
}
