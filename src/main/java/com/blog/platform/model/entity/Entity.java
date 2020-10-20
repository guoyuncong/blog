package com.blog.platform.model.entity;

import lombok.Data;

import java.util.Date;

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

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;


}
