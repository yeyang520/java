package boy.learning.web.response;

import org.apache.commons.io.IOUtils;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * 字节数据响应体
 */
@WebServlet("/resp4")
public class ResponseDemo4 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //1.读取文件
        FileInputStream fis = new FileInputStream("F:\\photo\\genshin\\bg.jpg");

        //2.通过Response对象获取字符输出流
        ServletOutputStream os = response.getOutputStream();
        //2.写数据,完成流的copy
        /*byte[] buff = new byte[1024];
        int len = 0;
        while((len = fis.read(buff))!=-1){
            os.write(buff,0,len);
        }*/
        IOUtils.copy(fis,os);

        fis.close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
