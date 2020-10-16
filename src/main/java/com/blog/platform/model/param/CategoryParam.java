package com.blog.platform.model.param;

import lombok.Data;

import javax.validation.constraints.*;

/**
 * 分类请求参数
 *
 * @author: rookie
 * @date: 2020-10-10
 */
@Data
public class CategoryParam {

    /**
     * 主键ID
     */
    private String id;

    /**
     * 名称
     */
    @NotBlank(message = "名称不能为空")
    private String name;

    /**
     * 排序
     */
    @NotNull(message = "排序不能为空")
    @Max(value = 100)
    @Min(value = 0)
    private Integer sort;

    /**
     * 父级ID
     */
    private String parentId;

    /**
     * 分类等级
     */
    private Integer level;
}
