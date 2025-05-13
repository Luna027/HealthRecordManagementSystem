package com.gzy.hrms_springboot.exception;
import com.gzy.hrms_springboot.common.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
class GlobalExceptionHandler {
    @ExceptionHandler({ServiceException.class})
    @ResponseBody
    public Result handle(ServiceException se) {
        return Result.error(se.getCode(), se.getMessage());
    }
}
