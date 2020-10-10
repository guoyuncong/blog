package com.blog.platform.model.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * 角色
 */
@Data
public class RoleDTO extends EntityDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    private String id;

    /**
     * 角色名称
     */
    private String name;

    /**
     * 描述
     */
    private String remark;

    /**
     * 状态
     */
    private Integer status;

    /**
     * 排序
     */
    private Integer sort;
}
