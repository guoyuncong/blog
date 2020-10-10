package com.blog.platform.basic.annotation;

import com.blog.platform.basic.enums.BusinessType;

import java.lang.annotation.*;

/**
 * 操作日志注解
 *
 * @author: rookie
 * @date: 2020-10-10
 */
@Target({ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Log {

    /**
     * 模块名称
     */
    String module() default "";

    /**
     * 业务操作类型
     */
    BusinessType businessType() default BusinessType.OTHER;

    /**
     * 是否保存请求的参数
     */
    boolean saveParam() default true;
}
