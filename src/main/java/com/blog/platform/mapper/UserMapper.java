package com.blog.platform.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.blog.platform.model.entity.User;
import org.springframework.stereotype.Repository;

/**
 * 用户表
 *
 * @author: rookie
 * @date: 2020-10-10
 */
@Repository
public interface UserMapper extends BaseMapper<User> {
}
