package com.blog.platform.model.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * 文章分类关联表
 */
@Getter
@Setter
@ToString
public class PostCategory extends Entity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    private String id;

    /**
     * 文章ID
     */
    private String postsId;

    /**
     * 类别ID
     */
    private String categoryId;
}