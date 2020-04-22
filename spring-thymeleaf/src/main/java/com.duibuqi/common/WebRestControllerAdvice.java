package com.duibuqi.common;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author CC 2018-06-19
 */
@RestControllerAdvice
public class WebRestControllerAdvice {
    /**
     * 自定义异常
     * @param e
     * @return
     */
    @ExceptionHandler({ResultException.class})
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    private Result resultExceptionHandler(ResultException e) {
        return new Result(e.getCode(), e.getMessage());
    }

}
