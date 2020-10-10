package com.blog.platform.model.dto;

import com.blog.platform.model.entity.User;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class UserInfoDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户基本信息
     */
    private User user;

    /**
     * 用户权限信息
     */
    private List<String> permissions;

    /**
     * 用户角色信息
     */
    private List<String> roles;
}
