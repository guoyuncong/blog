package com.blog.platform.service;

import com.blog.platform.model.entity.OperateLog;

public interface OperateLogService {

    /**
     * 保存操作日志
     *
     * @param operateLog bean
     */
    void save(OperateLog operateLog);
}
