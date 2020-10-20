package com.blog.platform.model.param;

import lombok.Data;

import javax.validation.constraints.*;

/**
 * 标签请求参数
 *
 * @author: rookie
 * @date: 2020-10-10
 */
@Data
public class LabelParam {

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
     * 等级
     */
    private Integer level;

    /**
     * 排序
     */
    @NotNull
    @Min(value = 0, message = "排序数值不能小于0")
    @Max(value = 100, message = "排序数值不能大于100")
    private Integer sort;

    /**
     * 父级ID
     */
    private String parentId;
}
