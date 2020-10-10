package com.blog.platform.model.param;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * 登录请求参数
 *
 * @author: rookie
 * @date: 2020-10-10
 */
@Data
public class LoginParam {

    /**
     * 用户名
     */
    @NotBlank(message = "账号不能为空")
    @Size(max = 20, message = "账号字符长度不能超过{max}")
    private String username;

    /**
     * 密码
     */
    @NotBlank(message = "密码不能为空")
    @Size(max = 20, message = "密码字符长度不能超过{max}")
    private String password;

    /**
     * 验证码
     */
    @NotBlank(message = "验证码不能为空")
    @Size(max = 20, message = "验证码字符长度不能超过{max}")
    private String code;

    /**
     * 票据
     * 与验证码一一对应，用于验证验证码
     */
    private String ticket;
}
