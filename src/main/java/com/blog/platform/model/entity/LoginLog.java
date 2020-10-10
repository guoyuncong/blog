package com.blog.platform.model.entity;

import lombok.Data;

@Data
public class LoginLog extends Entity {

    /**
     * 主键ID
     */
    private String id;

    /**
     * 用户名
     */
    private String userId;

    /**
     * 登录状态
     */
    private Integer status;

    /**
     * IP地址
     */
    private String ip;

    /**
     * 登陆地
     */
    private String location;

    /**
     * 操作系统
     */
    private String os;

    /**
     * 浏览器类型
     */
    private String browser;
}
