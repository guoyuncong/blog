package com.blog.platform.service.impl;

import com.blog.platform.mapper.LoginLogMapper;
import com.blog.platform.model.entity.LoginLog;
import com.blog.platform.service.LoginLogService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class LoginLogServiceImpl implements LoginLogService {

//    private final LoginLogMapper loginLogMapper;


    @Override
    public void save(LoginLog loginLog) {
//        loginLogMapper.insert(loginLog);
    }
}
