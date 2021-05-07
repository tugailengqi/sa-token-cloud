package com.lengqi.cloud.admin.common.exception;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.lengqi.cloud.admin.common.result.ResultVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * 全局系统异常处理
 *
 * @author hxrui
 * @date 2020-02-25 13:54
 **/
//@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(IllegalArgumentException.class)
    public ResultVo handleIllegalArgumentException(IllegalArgumentException e) {
        log.error("非法参数异常，异常原因：{}",e.getMessage(),e);
        return ResultVo.failed(e.getMessage());
    }


    @ExceptionHandler(JsonProcessingException.class)
    public ResultVo handleJsonProcessingException(JsonProcessingException e) {
        log.error("Json转换异常，异常原因：{}",e.getMessage(),e);
        return ResultVo.failed(e.getMessage());
    }

    @ExceptionHandler(BizException.class)
    public ResultVo handleBizException(BizException e) {
        log.error("业务异常，异常原因：{}",e.getMessage(),e);
        if (e.getResultCode() != null) {
            return ResultVo.failed(e.getResultCode());
        }
        return ResultVo.failed(e.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public ResultVo handleException(Exception e) {
        log.error("未知异常，异常原因：{}",e.getMessage(),e);
        return ResultVo.failed(e.getMessage());
    }
}
