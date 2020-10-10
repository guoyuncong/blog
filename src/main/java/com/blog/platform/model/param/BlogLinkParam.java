package com.blog.platform.model.param;

import com.blog.platform.basic.enums.LinkType;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * 链接表
 */
@Getter
@Setter
@ToString
public class BlogLinkParam {

    /**
     * 主键ID
     */
    private String linkId;

    /**
     * 链接名称
     */
    @NotBlank
    @Size(max = 20, message = "链接名称字符长度不能超过{max}")
    private String linkName;

    /**
     * 链接类型
     */
    @NotBlank
    private LinkType linkType;

    /**
     * 链接描述
     */
    @Size(max = 100, message = "链接描述字符长度不能超过{max}")
    private String linkDescription;

    /**
     * 链接地址
     */
    @Size(max = 50, message = "链接地址链接描述字符长度不能超过{max}")
    private String linkUrl;

    /**
     * 链接关联图标ID
     */
    private String linkIconId;
}
