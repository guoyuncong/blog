package com.blog.platform.service;

import com.blog.platform.model.dto.UserInfoDTO;
import com.blog.platform.model.param.LoginParam;

public interface LoginService {
    /**
     * 用户登录
     *
     * @param loginParam 登录参数
     * @return token
     */
    String login(LoginParam loginParam);

    /**
     * 用户退出
     */
    void logout();

    /**
     * 获取当前登录人信息
     *
     * @return 登录人信息
     */
    UserInfoDTO getUserInfo();
}
