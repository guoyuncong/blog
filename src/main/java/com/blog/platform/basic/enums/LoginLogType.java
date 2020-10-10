package com.blog.platform.basic.enums;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum LoginLogType {

    /**
     * 登录|退出日志
     */
    LOGIN(1, "登录"),
    LOGOUT(2, "退出"),

    ;

    private Integer status;

    private String desc;
}
