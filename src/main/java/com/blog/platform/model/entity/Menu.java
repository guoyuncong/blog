package com.blog.platform.model.entity;

import lombok.Data;

/**
 * 菜单实体类
 *
 * @author: rookie
 * @date: 2020-10-10
 */
@Data
public class Menu extends Entity{

    /**
     * 主键ID
     */
    private String id;

    /**
     * 权限名称
     */
    private String name;

    /**
     * 权限标识
     */
    private String mark;

    /**
     * 排序
     */
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
     * 是否为外链（0是 1否）
     */
    private boolean externalLink;

    /**
     * 类型
     */
    private Integer type;

    /**
     * 状态
     */
    private Integer status;

    /**
     * 图标ID
     */
    private String icon;

    /**
     * 父级ID
     */
    private String parentId;



}
