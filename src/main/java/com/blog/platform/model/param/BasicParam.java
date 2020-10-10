package com.blog.platform.model.param;

import cn.hutool.core.date.DatePattern;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * 基本信息接收参数
 *
 * @author: rookie
 * @date: 2020-10-10
 */
@Data
public class BasicParam{

    /**
     * 主键ID
     */
    private String blogId;

    /**
     * 博客名称
     */
    @NotBlank(message = "博客名称不能为空")
    @Size(max = 20, message = "博客名称的字符长度不能超过{max}")
    private String blogName;

    /**
     * 博客描述
     */
    @NotBlank(message = "博客名称不能为空")
    @Size(max = 100, message = "博客名称的字符长度不能超过{max}")
    private String blogDescription;

    /**
     * 博主姓名
     */
    @Size(max = 20, message = "博主姓名的字符长度不能超过{max}")
    private String bloggerName;

    /**
     * 博主昵称
     */
    @Size(max = 20, message = "博主昵称的字符长度不能超过{max}")
    private String bloggerNickName;

    /**
     * 博主生日
     */
    @DateTimeFormat(pattern = DatePattern.NORM_DATE_PATTERN)
    private Date bloggerBirthday;

    /**
     * 博主手机号
     */
    @Size(max = 13, message = "博主手机号的字符长度不能超过{max}")
    private String bloggerMobile;

    /**
     * 博主邮箱
     */
    @Size(max = 30, message = "博主邮箱的字符长度不能超过{max}")
    private String bloggerEmail;

    /**
     * 头像地址
     */
    @Size(max = 50, message = "头像地址的字符长度不能超过{max}")
    private String headPortraitUrl;

    /**
     * 首页页脚
     */
    @Size(max = 100, message = "首页页脚的字符长度不能超过{max}")
    private String homePageFooter;

    /**
     * 内容页脚
     */
    @Size(max = 100, message = "内容页脚的字符长度不能超过{max}")
    private String contentPageFooter;
}
