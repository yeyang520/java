package boy.learning.controller;

import boy.learning.exception.BusinessException;
import boy.learning.exception.SystemException;
import org.apache.ibatis.builder.BuilderException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ProjectExceptiondvice {
    @ExceptionHandler(SystemException.class)
    public Result doSystemException(SystemException ex){
        //记录日志
        //发送消息给运维
        //发送邮件给开发人员
        return new Result(ex.getCode(),null,ex.getMessage());
    }

    @ExceptionHandler(BusinessException.class)
    public Result doBuinessException(BusinessException ex){

        return new Result(ex.getCode(),null,ex.getMessage());
    }

    @ExceptionHandler
    public Result doException(Exception ex){
        //记录日志
        //发送消息给运维
        //发送邮件给开发人员
        return new Result(Code.SYSTEM_UNKONW_ERR,null,"系统繁忙，请稍后再试");
    }
}
