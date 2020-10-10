package com.blog.platform.model.entity;

import lombok.Data;

@Data
public class OperateLog extends Entity {

    /**
     * 主键ID
     */
    private String id;

    /**
     * 模块
     */
    private String module;

    /**
     * 业务类型
     */
    private String businessType;

    /**
     * 状态
     */
    private Integer status;

    /**
     * 方法名称
     */
    private String method;

    /**
     * 请求方式
     */
    private String way;

    /**
     * 操作人ID
     */
    private String userId;

    /**
     * 请求URL
     */
    private String uri;

    /**
     * 请求IP地址
     */
    private String ip;

    /**
     * 请求参数
     */
    private String param;

    /**
     * 结果
     */
    private String result;

    /**
     * 错误
     */
    private String errorMsg;

}
