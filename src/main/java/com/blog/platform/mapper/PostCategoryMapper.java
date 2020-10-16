package com.blog.platform.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.blog.platform.model.entity.PostCategory;
import org.springframework.stereotype.Repository;

/**
 * 文章分类表
 *
 * @author: rookie
 * @date: 2020-10-10
 */
@Repository
public interface PostCategoryMapper extends BaseMapper<PostCategory> {
}
