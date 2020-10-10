package com.blog.platform.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.blog.platform.model.entity.PostLabel;
import org.springframework.stereotype.Repository;

/**
 * 文章标签表
 *
 * @author: rookie
 * @date: 2020-10-10
 */
@Repository
public interface PostLabelMapper extends BaseMapper<PostLabel> {
}
