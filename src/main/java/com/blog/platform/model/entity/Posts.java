package com.blog.platform.model.entity;

import com.blog.platform.basic.enums.PostStatus;
import com.blog.platform.basic.enums.PostTop;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * 文章表
 */
@Getter
@Setter
@ToString
public class Post extends Entity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    private String postsId;

    /**
     * 文章标题
     */
    private String postsTitle;

    /**
     * 文章描述
     */
    private String postsDescription;

    /**
     * 文章状态
     */
    private PostStatus postsStatus;

    /**
     * 文章置顶
     */
    private PostTop postsTop;

    /**
     * 文章查看次数
     */
    private Integer postsVisitNum;

    /**
     * 文章修改次数
     */
    private Integer postsModifyNum;

    /**
     * 文章内容 markdown
     */
    private String postsMarkdown;

    /**
     * 文章内容 html
     */
    private String postsHtml;
}
