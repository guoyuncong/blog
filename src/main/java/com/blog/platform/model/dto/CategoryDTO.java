package com.blog.platform.model.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * 分类表
 */
@Getter
@Setter
@ToString
public class CategoryDTO extends EntityDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    private String id;

    /**
     * 类别名称
     */
    private String name;

    /**
     * 类别等级
     */
    private String level;

    /**
     * 父类别id
     */
    private String parentId;

    /**
     * 排序
     */
    private Integer sort;
}
