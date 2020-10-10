package com.blog.platform.model.param;

import lombok.Data;

@Data
public class UserParam {

    /**
     * 用户ID
     */
    private String id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 用户昵称
     */
    private String nickname;

    /**
     * 状态
     */
    private Integer status;




}
