package com.blog.platform.basic.constants;

/**
 * Redis 常量类
 *
 * @author: rookie
 * @date: 2020-10-10
 */
public class RedisConstants {

    /**
     * 登录用户 redis key
     */
    public static final String LOGIN_USER_KEY = "login_tokens:";

    /**
     * 登录验证码 redis key
     */
    public static final String LOGIN_CAPTCHA_KEY = "login_captcha:";
}
