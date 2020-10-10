package com.blog.platform.basic.aop.handler;

import com.blog.platform.basic.enums.ResultCode;
import com.blog.platform.basic.exception.BizException;
import com.blog.platform.model.dto.ResultDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局处理异常
 *
 * @author: rookie
 * @date: 2020-10-10
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 业务异常
     *
     * @param ex 捕获异常
     * @return ResponseEntity<ResultDTO>
     */
    @ExceptionHandler({BizException.class})
    public ResultDTO bizExceptionHandler(Exception ex) {
        log.error("bizException => ", ex);
        BizException biz = (BizException) ex;
        if (biz.getData() == null) {
            return ResultDTO.of(biz.getCode());
        } else {
            return ResultDTO.of(biz.getCode(), biz.getData());
        }
    }

    /**
     * Spring Security 认证异常
     *
     * @param ex 捕获异常
     * @return ResponseEntity<ResultDTO>
     */
    @ExceptionHandler({InternalAuthenticationServiceException.class})
    public ResultDTO internalAuthenticationExceptionHandler(InternalAuthenticationServiceException ex) {
        log.error("spring security exception => ", ex);
        Throwable cause = ex.getCause();
        if (cause instanceof BizException) {
            BizException bizException = (BizException) cause;
            return ResultDTO.of(bizException.getCode());
        }
        return ResultDTO.of(ResultCode.BIZ_SYSTEM_EXECUTE_ERROR);
    }

    /**
     * 参数格式不匹配
     */
    @ExceptionHandler({HttpMessageNotReadableException.class})
    public ResultDTO httpMessageNotReadableException(Exception ex) {
        return ResultDTO.of(ResultCode.USER_REQUEST_PARAM_NOT_MATCH);
    }

}
