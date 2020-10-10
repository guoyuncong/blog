package com.blog.platform.security.service;

import com.blog.platform.basic.enums.ResultCode;
import com.blog.platform.basic.enums.UserStatus;
import com.blog.platform.basic.exception.BizException;
import com.blog.platform.model.entity.User;
import com.blog.platform.security.LoginUser;
import com.blog.platform.service.PermissionService;
import com.blog.platform.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

/**
 * 用户认证处理
 */
@Service
@AllArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserService userService;

    private final PermissionService permissionService;

    @Override
    public UserDetails loadUserByUsername(String username) {
        // 查找指定用户名对应的 User
        User user = userService.getUserByUserName(username);
        if (user == null) {
            // 用户账户不存在
            throw BizException.of(ResultCode.USER_ACCOUNT_NOT_EXIST);
        } else if (UserStatus.DISABLE.getStatus().equals(user.getStatus())) {
            // 用户账户已禁用
            throw BizException.of(ResultCode.USER_ACCOUNT_DISABLE);
        } else if (UserStatus.INVALIDED.getStatus().equals(user.getStatus())) {
            // 用户账户已作废
            throw BizException.of(ResultCode.USER_ACCOUNT_HAS_INVALIDED);
        }
        return new LoginUser(user, permissionService.getUserPermissions(user));
    }
}
