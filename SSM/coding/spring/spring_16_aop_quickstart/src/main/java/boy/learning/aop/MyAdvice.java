package boy.learning.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

//告诉spring来加载我
@Component
//告诉spring这东西是用来做aop的
@Aspect
public class MyAdvice {

    //定义切入点  定义通知
//    @Pointcut("execution(void boy.learning.service.BookService.update())")
//    @Pointcut("execution(* boy.learning.service.BookService.update(*))")
//    @Pointcut("execution(void boy.*.*.*.*.update())")
//    @Pointcut("execution(* *..*(..))")
    @Pointcut("execution(void boy.learning.service.BookService.up*())")
    private void pt(){}


    //绑定切入点和通知
    @Before("pt()")
    public void method(){
        System.out.println(System.currentTimeMillis());
    }
}
