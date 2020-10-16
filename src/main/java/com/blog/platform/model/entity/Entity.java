package com.blog.platform.model.entity;

import lombok.Data;

@Data
public class Entity {

    /**
     * 版本号
     */
    private Integer version;

    /**
     * 由谁创建
     */
    private String createBy;

    /**
     * 由谁修改
     */
    private String updateBy;


}
