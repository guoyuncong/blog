package com.blog.platform.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.blog.platform.model.entity.LoginLog;
import org.springframework.stereotype.Repository;

/**
 * 登录日志表
 *
 * @author: rookie
 * @date: 2020-10-10
 */
@Repository
public interface LoginLogMapper extends BaseMapper<LoginLog> {
}
