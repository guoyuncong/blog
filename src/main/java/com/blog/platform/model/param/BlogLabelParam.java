package com.blog.platform.model.param;

import com.blog.platform.basic.enums.LabelLevel;
import com.blog.platform.model.entity.Entity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * 标签表
 */
@Getter
@Setter
@ToString
public class BlogLabelParam extends Entity {

    /**
     * 主键ID
     */
    private String labelId;

    /**
     * 标签名称
     */
    @NotBlank
    @Size(max = 20, message = "链接名称字符长度不能超过{max}")
    private String labelName;

    /**
     * 标签等级
     */
    @NotBlank
    private LabelLevel labelLevel;

    /**
     * 父标签ID
     */
    private String labelParentId;
}
