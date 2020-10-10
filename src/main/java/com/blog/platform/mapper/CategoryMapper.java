package com.blog.platform.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.blog.platform.model.entity.Category;
import org.springframework.stereotype.Repository;

/**
 * 分类表
 *
 * @author: rookie
 * @date: 2020-10-10
 */
@Repository
public interface CategoryMapper extends BaseMapper<Category> {
}
