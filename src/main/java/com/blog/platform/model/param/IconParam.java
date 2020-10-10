package com.blog.platform.model.param;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * 基本信息表
 */
@Data
public class IconParam {

    /**
     * 图标ID
     */
    private String iconId;

    /**
     * 图标名称
     */
    @NotBlank(message = "图标名称不能为空")
    @Size(max = 20, message = "图标名称字符长度不能超过{max}")
    private String iconName;

    /**
     * 图标描述
     */
    @Size(max = 100, message = "图标描述字符长度不能超过{max}")
    private String iconDescription;

    /**
     * 图标链接
     */
    @Size(max = 100, message = "图标链接字符长度不能超过{max}")
    private String iconUrl;
}
