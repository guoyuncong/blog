package com.blog.platform.service;

import com.blog.platform.model.entity.User;
import com.blog.platform.model.param.PermissionParam;

import java.util.List;

public interface PermissionService {

    /**
     * 添加权限
     *
     * @param permissionParam 权限参数
     * @return 主键ID
     */
    String save(PermissionParam permissionParam);

    /**
     * 添加权限
     *
     * @param permissionParam 权限参数
     */
    void update(PermissionParam permissionParam);

    /**
     * 删除权限
     *
     * @param permissionId 权限ID
     */
    void delete(String permissionId);

    /**
     * 获取用户权限
     *
     * @param user bean
     * @return 权限标识集合
     */
    List<String> getUserPermissions(User user);
}
