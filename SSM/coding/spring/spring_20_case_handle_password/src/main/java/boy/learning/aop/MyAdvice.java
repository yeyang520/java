package boy.learning.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.lang.reflect.Array;
import java.util.Arrays;

//告诉spring来加载我
@Component
//告诉spring这东西是用来做aop的
@Aspect
public class MyAdvice {


    @Pointcut("execution(boolean boy.learning.service.*Service.*(..))")
    private void pt(){}

    @Around("MyAdvice.pt()")
    public Object trimStr(ProceedingJoinPoint pjp) throws Throwable {

        //去空格
        Object[] args = pjp.getArgs();
        //对原始数据的每一个参数进行操作
        for(int i=0;i<args.length;++i){
            //判断参数是否为字符串
            if(args[i].getClass().equals(String.class)){
                args[i] = args[i].toString().trim();
            }
        }


        Object ret = pjp.proceed(args);


        return ret;
    }

}
