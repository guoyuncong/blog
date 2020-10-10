package com.blog.platform.model.entity;

import lombok.Data;

/**
 * 角色
 */
@Data
public class Role extends Entity {

    /**
     * 主键ID
     */
    private String id;

    /**
     * 角色名称
     */
    private String name;

    /**
     * 角色标识
     */
    private String mark;

    /**
     * 描述
     */
    private String description;

    /**
     * 状态
     */
    private Integer status;

    /**
     * 排序
     */
    private Integer sort;
}
