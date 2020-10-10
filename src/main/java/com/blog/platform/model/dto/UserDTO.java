package com.blog.platform.model.dto;

import com.blog.platform.basic.enums.UserStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.io.Serializable;

@Data
public class UserDTO extends EntityDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    private String id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    @JsonIgnore
    private String password;

    /**
     * 用户昵称
     */
    private String nickName;

    /**
     * 用户状态
     */
    private UserStatus userStatus;
}
