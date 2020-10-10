package com.blog.platform.basic.enums;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum OperateStatus {

    /**
     * 成功
     */
    SUCCESS("成功"),

    /**
     * 失败
     */
    FAILURE("失败"),

    ;

    private String desc;
}
