package com.blog.platform.security.service;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import com.blog.platform.basic.constants.Constants;
import com.blog.platform.basic.util.SecurityUtil;
import com.blog.platform.security.LoginUser;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 权限核验
 *
 * @author: rookie
 * @date: 2020-10-10
 */
@Component
@AllArgsConstructor
public class PermissionCheckService {

    private final TokenService tokenService;

    /**
     * 验证用户是否具备某权限
     *
     * @param permission 权限字符串
     * @return 用户是否具备某权限
     */
    public boolean hasPermission(String permission) {
        // 如果未设置需要的权限
        if (StrUtil.isEmpty(permission)) {
            return false;
        }
        // 获得当前 LoginUser
        LoginUser loginUser = SecurityUtil.getLoginUser();
        // 如果不存在，或者没有任何权限，说明权限验证不通过
        if (loginUser == null || CollUtil.isEmpty(loginUser.getPermissions())) {
            return false;
        }
        // 判断是否包含权限
        return hasPermissions(loginUser.getPermissions(), permission);
    }

    /**
     * 验证用户是否拥有某权限
     *
     * @param permissions
     * @param permission
     * @return
     */
    private boolean hasPermissions(List<String> permissions, String permission) {
        return permissions.contains(Constants.PERMISSION_ALL) || permissions.contains(StrUtil.trim(permission));
    }
}
