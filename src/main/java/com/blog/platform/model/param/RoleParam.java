package com.blog.platform.model.param;

import lombok.Data;


/**
 * 角色请求参数
 */
@Data
public class RoleParam {

    /**
     * 主键ID
     */
    private String id;

    /**
     * 名称
     */
    private String name;

    /**
     * 备注
     */
    private String remark;

    /**
     * 状态
     */
    private Integer status;

    /**
     * 排序
     */
    private Integer sort;
}
