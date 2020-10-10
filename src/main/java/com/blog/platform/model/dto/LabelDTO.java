package com.blog.platform.model.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * 标签表
 */
@Getter
@Setter
@ToString
public class LabelDTO extends EntityDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    private String id;

    /**
     * 标签名称
     */
    private String name;

    /**
     * 标签等级
     */
    private String level;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 父标签ID
     */
    private String parentId;
}
