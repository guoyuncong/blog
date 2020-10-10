package com.blog.platform.model.dto;

import com.blog.platform.basic.enums.ResultCode;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;


@Getter
@ToString
@AllArgsConstructor(access =  AccessLevel.PRIVATE)
public final class ResultDTO<T> {

    /**
     * 返回码
     */
    private final String code;

    /**
     * 返回信息
     */
    private final String msg;

    /**
     * 数据
     */
    private final T data;

    public static <T> ResultDTO<T> ofSuccess(T detail) {
        return of(ResultCode.SUCCESS, detail);
    }

    public static <T> ResultDTO<T> ofSuccess() {
        return of(ResultCode.SUCCESS);
    }

    public static <T> ResultDTO<T> of(ResultCode resultCode, T data) {
        return new ResultDTO<>(resultCode.getCode(), resultCode.getMessage(), data);
    }

    public static <T> ResultDTO<T> of(ResultCode resultCode) {
        return new ResultDTO<>(resultCode.getCode(), resultCode.getMessage(), null);
    }
}
