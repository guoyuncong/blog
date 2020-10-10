package com.blog.platform.model.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 基本信息表
 */
@Data
public class Basic extends Entity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    private String id;

    /**
     * 博客名称
     */
    private String blogName;

    /**
     * 博客描述
     */
    private String blogDescription;

    /**
     * 博主姓名
     */
    private String bloggerName;

    /**
     * 博主昵称
     */
    private String bloggerNickName;

    /**
     * 博主生日
     */
    private Date bloggerBirthday;

    /**
     * 博主手机号
     */
    private String bloggerMobile;

    /**
     * 博主邮箱
     */
    private String bloggerEmail;

    /**
     * 头像地址
     */
    private String headPortraitUrl;

    /**
     * 首页页脚
     */
    private String homePageFooter;

    /**
     * 内容页脚
     */
    private String contentPageFooter;
}
