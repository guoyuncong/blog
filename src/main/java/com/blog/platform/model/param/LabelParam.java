package com.blog.platform.model.param;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * 标签请求参数
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
    @NotBlank(message = "等级不能为空")
    private String level;

    /**
     * 排序
     */
    @NotBlank(message = "排序不能为空")
    @Size(max = 99, message = "排序值限定不能超过100")
    private Integer sort;

    /**
     * 父级ID
     */
    private String parentId;
}
