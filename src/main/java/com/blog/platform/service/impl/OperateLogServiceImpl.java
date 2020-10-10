package com.blog.platform.service.impl;

import com.blog.platform.mapper.OperateLogMapper;
import com.blog.platform.model.entity.OperateLog;
import com.blog.platform.service.OperateLogService;
import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OperateLogServiceImpl implements OperateLogService {

//    private final OperateLogMapper operateLogMapper;

    @Async("operationPool")
    @Override
    public void save(OperateLog operateLog) {
//        operateLogMapper.insert(operateLog);
    }
}
