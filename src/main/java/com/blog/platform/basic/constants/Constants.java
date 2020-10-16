package com.blog.platform.basic.constants;

/**
 * 全局常量
 *
 * @author: rookie
 * @date: 2020-10-10
 */
public class Constants {

    /**
     * 用户管理员标识
     */
    public static final Integer USER_ADMIN = 1;

    /**
     * 权限最上级
     */
    public static final String PERMISSION_TOP = "0";

    /**
     * 所有权限标识（管理员所有）
     */
    public static final String PERMISSION_ALL = "*:*:*";

    /**
     * 最高级角色标识（管理员所有）
     */
    public static final String ROLE_ADMIN = "admin";

    /**
     * 等级
     * 0    父级
     * 1    子级
     */
    public static final Integer LEVEL_PARENT = 0;
    public static final Integer LEVEL_CHILD = 1;


}
