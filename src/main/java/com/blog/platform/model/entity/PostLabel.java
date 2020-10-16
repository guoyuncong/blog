package com.blog.platform.model.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * 文章标签关联表
 */
@Getter
@Setter
@ToString
public class PostLabel extends Entity implements Serializable {

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
     * 标签ID
     */
    private String labelId;
}