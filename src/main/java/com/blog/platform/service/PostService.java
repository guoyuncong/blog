package com.blog.platform.service;

import com.blog.platform.model.param.PostParam;

public interface PostService {

    /**
     * 保存文章
     *
     * @param postParam 文章参数
     * @return 文章主键ID
     */
    String save(PostParam postParam);
}
