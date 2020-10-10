package com.blog.platform.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.blog.platform.model.entity.Label;
import org.springframework.stereotype.Repository;

/**
 * 标签表
 *
 * @author: rookie
 * @date: 2020-10-10
 */
@Repository
public interface LabelMapper extends BaseMapper<Label> {
}
