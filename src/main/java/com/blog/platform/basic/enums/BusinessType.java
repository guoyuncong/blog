package com.blog.platform.basic.enums;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 业务操作类型
 *
 * @author: rookie
 * @date: 2020-10-10
 */
@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum BusinessType {

    /**
     * 新增
     */
    SAVE("新增"),

    /**
     * 修改
     */
    UPDATE("修改"),

    /**
     * 删除
     */
    DELETE("删除"),

    /**
     * 查询
     */
    QUERY("查询"),

    /**
     * 导出
     */
    EXPORT("导出"),

    /**
     * 导入
     */
    IMPORT("导入"),

    /**
     * 其它
     */
    OTHER("其他"),

    ;

    private String desc;
}
