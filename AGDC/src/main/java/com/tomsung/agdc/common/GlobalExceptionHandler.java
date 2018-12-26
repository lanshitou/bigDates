package com.tomsung.agdc.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@ControllerAdvice
public class GlobalExceptionHandler {

    private Logger logger = LoggerFactory.getLogger(this.getClass());


    @ExceptionHandler(value = ServiceException.class)
    @ResponseBody
    public Object customHandler(ServiceException e) {
        return ResultModel.error(e.getResultStatus(), e.getContent());
    }

    @ExceptionHandler(value = {
            MissingServletRequestParameterException.class,
            HttpMessageNotReadableException.class,
            MethodArgumentTypeMismatchException.class
    })
    @ResponseBody
    public Object parameterErrorHandler(Exception e) {
        logger.error(e.getMessage(), e);
        return ResultModel.error(ResultStatus.PARAM_ERR, e.getMessage());
    }


    @ExceptionHandler(value = DuplicateKeyException.class)
    @ResponseBody
    public Object duplicateKeyErrorHandler(Exception e) {
        logger.error(e.getMessage(), e);
        return ResultModel.error(ResultStatus.DUPLICATE_KEY_ERR);
    }

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Object exceptionHandler(Exception e) {
        logger.error(e.getMessage(), e);
        return ResultModel.error(ResultStatus.SYSTEM_ERR);
    }

}
