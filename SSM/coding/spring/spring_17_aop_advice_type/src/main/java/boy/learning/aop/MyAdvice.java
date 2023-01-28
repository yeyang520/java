package boy.learning.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

//告诉spring来加载我
@Component
//告诉spring这东西是用来做aop的
@Aspect
public class MyAdvice {


    @Pointcut("execution(void boy.learning.*.*.*(..))")
    private void pt(){}

    @Pointcut("execution(int boy.learning.service.BookService.selectById(..))")
    private void pt2(){}

    //绑定切入点和通知
//    @Before("pt()")
    public void before(){
        System.out.println("before...");
    }

//    @After("pt()")
    public void after(){
        System.out.println("after...");
    }

    @Around("pt()")
    public void around(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("around before...");
        //表示对原始操作的调用
        Object proceed = pjp.proceed();

        System.out.println("around after...");
        System.out.println(proceed);
    }

//    @Around("pt2()")
    public Object around2(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("around before...");

        //表示对原始操作的调用
        Object o = pjp.proceed();

        System.out.println("around after...");

        return o;
    }



    public void afterThorwing(){
        System.out.println("afterThorwing...");
    }

    @AfterReturning("pt()")
    public void afterReturning(){
        System.out.println("afterReturning...");
    }
}
