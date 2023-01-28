package boy.learning.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyAdvice {

    //匹配业务层所有方法
    @Pointcut("execution(* boy.learning.service.*Service.*(..))")
    private void servicePt(){}


    @Around("servicePt()")
    public void speed(ProceedingJoinPoint pjp) throws Throwable {

        //拿出标签
        Signature signature = pjp.getSignature();
        //包名
        String className = signature.getDeclaringTypeName();
        //类名
        String methodName = signature.getName();


        Long start = System.currentTimeMillis();

        for(int i=0;i<10000;++i){
            Object ret = pjp.proceed();
        }

        Long end = System.currentTimeMillis();

        System.out.println("业务层接口万次执行"+className+"."+methodName+"--->"+(end - start)+"ms");
    }


}
