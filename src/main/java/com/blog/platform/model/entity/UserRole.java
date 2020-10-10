package com.blog.platform.model.entity;

import lombok.Data;

/**
 * 用户角色表
 */
@Data
public class UserRole extends Entity {

    /**
     * 主键ID
     */
    private String id;

    /**
     * 用户ID
     */
    private String userId;

    /**
     * 角色ID
     */
    private String roleId;


}
