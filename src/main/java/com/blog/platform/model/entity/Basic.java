package com.blog.platform.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 基本信息
 *
 * @author: rookie
 * @date: 2020-10-10
 */
@Data
@TableName("basic")
public class Basic extends Entity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @TableId(type = IdType.ASSIGN_UUID)
    private String id;

    /**
     * 博客名称
     */
    private String blogName;

    /**
     * 博客描述
     */
    private String blogDesc;

    /**
     * 博主姓名
     */
    private String bloggerName;

    /**
     * 博主昵称
     */
    private String bloggerNickname;

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
