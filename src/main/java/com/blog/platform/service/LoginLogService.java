package com.blog.platform.service;

import com.blog.platform.model.entity.LoginLog;

public interface LoginLogService {

    /**
     * 新增
     *
     * @param operateLog   bean
     */
    void save(LoginLog loginLog);
}
