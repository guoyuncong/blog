package com.blog.platform.service;

import com.blog.platform.model.param.BasicParam;

/**
 * 博客基本信息 Service
 *
 * @author: rookie
 * @date: 2020-10-10
 */
public interface BasicService {

    /**
     * 添加博客基本信息
     *
     * @param basicParam 博客基本信息参数
     * @return 主键ID
     */
    String save(BasicParam basicParam);

    /**
     * 更新博客基本信息
     *
     * @param basicParam 博客基本信息参数
     */
    void update(BasicParam basicParam);
}
