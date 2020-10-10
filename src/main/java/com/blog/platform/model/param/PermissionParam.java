package com.blog.platform.model.param;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * 权限请求参数
 */
@Data
public class PermissionParam {

    /**
     * 主键ID
     */
    private String id;

    /**
     * 权限名称
     */
    @NotBlank
    private String name;

    /**
     * 父级权限ID
     */
    @NotBlank
    private String parentId;

    /**
     * 排序
     */
    @NotBlank
    private Integer sort;

    /**
     * 路由地址
     */
    private String path;

    /**
     * 组件路径
     */
    private String component;

    /**
     * 是否是外链
     */
    private boolean externalLink;

    /**
     * 菜单类型（1目录 2菜单 3按钮）
     */
    private Integer type;

    /**
     * 菜单状态
     */
    private Integer status;

    /**
     * 权限标识
     */
    private String mark;

    /**
     * 图标标识
     */
    private String icon;
}
