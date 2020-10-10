package com.blog.platform.model.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * 链接表
 */
@Getter
@Setter
@ToString
public class Link extends Entity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    private String id;

    /**
     * 链接名称
     */
    private String name;

    /**
     * 链接类型
     */
    private String type;

    /**
     * 链接状态
     */
    private Integer status;

    /**
     * 是否为外链（0是 1否）
     */
    private boolean externalLink;

    /**
     * 链接描述
     */
    private String description;

    /**
     * 链接地址
     */
    private String url;

    /**
     * 链接关联图标ID
     */
    private String icon;

    /**
     * 链接排序
     */
    private Integer sort;
}
