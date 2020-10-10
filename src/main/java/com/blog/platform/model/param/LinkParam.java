package com.blog.platform.model.param;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * 链接请求参数
 */
@Data
public class LinkParam {

    /**
     * 主键ID
     */
    private String id;

    /**
     * 名称
     */
    @NotBlank(message = "链接名称不能为空")
    private String name;

    /**
     * 类型
     */
    @NotBlank(message = "链接类型不能为空")
    private String type;

    /**
     * 状态
     */
    @NotBlank(message = "链接状态不能为空")
    private Integer status;

    /**
     * 是否是外链
     */
    @NotNull(message = "是否为外链不能为空")
    private boolean externalLink;

    /**
     * 链接地址
     */
    private String url;

    /**
     * 链接关联图标ID
     */
    private String icon;

    /**
     * 排序
     */
    @NotNull(message = "排序不能为空")
    private Integer sort;

    /**
     * 链接描述
     */
    private String description;
}
