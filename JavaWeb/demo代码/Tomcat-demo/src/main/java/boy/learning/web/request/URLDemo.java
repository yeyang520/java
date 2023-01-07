package boy.learning.web.request;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class URLDemo {
    public static void main(String[] args) throws UnsupportedEncodingException {
        //url编码
        String username = "张三";
        String encode = URLEncoder.encode(username, "utf-8");
        System.out.println(encode);

        //url解码
        String decode = URLDecoder.decode(username);
        System.out.println(decode);

        //Tomcat解码
        String decodeTomcat = URLDecoder.decode(encode, "ISO-8859-1");
        System.out.println(decodeTomcat);

        //3.转换为字节数组,编码
        byte[] bytes = decodeTomcat.getBytes("ISO-8859-1");
        for (byte b : bytes) {
            System.out.print(b+" ");
        }
        //4.将字节数组转化为字符串，解码
        String s = new String(bytes, "utf-8");
        System.out.println(s);
    }
}
