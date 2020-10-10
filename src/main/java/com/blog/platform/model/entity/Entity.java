package com.blog.platform.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Data
public class Entity {

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date updateTime;

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

    public Long getCreateDate() {
        return createTime.getTime();
    }

    public Long getUpdateDate() {
        return createTime.getTime();
    }
}
