package com.blog.platform.basic.exception;

import com.blog.platform.basic.enums.ResultCode;
import lombok.Getter;

@Getter
public class BizException extends RuntimeException {

    private ResultCode code;

    private Object data;

    private BizException(ResultCode code) {
        super(code.getMessage());
        this.code = code;
    }

    private BizException(ResultCode code, Object data) {
        super(code.getMessage());
        this.code = code;
        this.data = data;
    }

    public static BizException of(ResultCode code) {
        return new BizException(code);
    }

    public static BizException of(ResultCode code, Object data) {
        return new BizException(code, data);
    }
}
