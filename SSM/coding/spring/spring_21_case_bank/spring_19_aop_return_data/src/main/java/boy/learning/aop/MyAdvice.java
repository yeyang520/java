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


    @Pointcut("execution(* boy.learning.*.*.*(..))")
    private void pt(){}


    //绑定切入点和通知
//    @Before("pt()")
    public void before(JoinPoint jp){
        System.out.println(Arrays.toString(jp.getArgs()));
        System.out.println("before...");
    }

//    @After("pt()")
    public void after(){
        System.out.println("after...");
    }

    @Around("pt()")
    public void around(ProceedingJoinPoint pjp){
        System.out.println("around before...");

        Object[] args = pjp.getArgs();
        args[0] = 666;
        //表示对原始操作的调用
        try {
            Object proceed = pjp.proceed(args);
        } catch (Throwable e) {
            e.printStackTrace();
        }

        System.out.println("around after...");
    }


    @AfterThrowing(value="pt()",throwing = "t")
    public void afterThorwing (Throwable t) {
        System.out.println("afterThorwing...");
    }

    @AfterReturning(value="pt()",returning = "ret")
    public void afterReturning (JoinPoint jp,Object ret) {
        System.out.println("afterReturning..."+ret);
    }

}
