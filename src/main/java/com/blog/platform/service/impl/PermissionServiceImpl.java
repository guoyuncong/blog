package com.blog.platform.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.blog.platform.basic.constants.Constants;
import com.blog.platform.basic.util.SecurityUtil;
import com.blog.platform.mapper.MenuMapper;
import com.blog.platform.mapper.RolePermissionMapper;
import com.blog.platform.model.entity.Menu;
import com.blog.platform.model.entity.User;
import com.blog.platform.model.param.PermissionParam;
import com.blog.platform.service.PermissionService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class PermissionServiceImpl implements PermissionService {

    private final MenuMapper menuMapper;

    private final RolePermissionMapper rolePermissionMapper;

    @Override
    public String save(PermissionParam permissionParam) {
        checkSavePermissionParam(permissionParam);
        Menu menu = new Menu();
        BeanUtil.copyProperties(permissionParam, menu);
        menu.setCreateBy(SecurityUtil.getLoginUserId());
        menuMapper.insert(menu);
        return menu.getId();
    }

    @Override
    public void update(PermissionParam permissionParam) {
        checkEditPermissionParam(permissionParam);
        Menu menu = new Menu();
        BeanUtil.copyProperties(permissionParam, menu);
        menu.setUpdateBy(SecurityUtil.getLoginUserId());
        menuMapper.updateById(menu);
    }

    @Override
    public void delete(String permissionId) {
      /*  // 核验权限是否存在
        Permission permission = permissionMapper.getPermissionById(permissionId);
        if (permission == null) {
            throw BizException.of(ResultCode.BIZ_SYSTEM_PERMISSION_NOT_EXIST);
        }
        // 核验是否存在子级权限
        List<Permission> permissions = permissionMapper.getChildPermissionById(permissionId);
        if (CollUtil.isNotEmpty(permissions)) {
            throw BizException.of(ResultCode.BIZ_SYSTEM_PERMISSION_HAS_CHILD);
        }
        // 核验是否已被分配
        List<RolePermission> rolePermissions = rolePermissionMapper.getRolePermissionByPermissionId(permissionId);
        if (CollUtil.isNotEmpty(rolePermissions)) {
            throw BizException.of(ResultCode.BIZ_SYSTEM_PERMISSION_HAS_DISTRIBUTE);
        }
        // 删除
        permissionMapper.delete(permissionId);*/
    }

    @Override
    public List<String> getUserPermissions(User user) {
        List<String> permissions = new ArrayList<>();
        if (user.isAdmin()) {
            permissions.add(Constants.PERMISSION_ALL);
        } else {
            permissions.addAll(menuMapper.getMenuMarksByUserId(user.getId()));
        }
        return permissions;
    }


    /**
     * 修改权限参数核验
     *
     * @param permissionParam 权限参数
     */
    private void checkEditPermissionParam(PermissionParam permissionParam) {
       /* String id = permissionParam.getId();
        String name = permissionParam.getName();
        String parentId = permissionParam.getParentId();
        // 核验参数缺失
        if (StrUtil.isEmpty(id)) {
            throw BizException.of(ResultCode.USER_REQUEST_PARAM_ERROR);
        }
        // 核验本级是否存在
        Permission permission = permissionMapper.getPermissionById(id);
        if (permission == null) {
            throw BizException.of(ResultCode.BIZ_SYSTEM_PERMISSION_NOT_EXIST);
        }
        // 核验权限名称是否存在，不同层级下可拥有相同的名称
        permission = permissionMapper.getPermissionByNameAndParentId(name, parentId);
        if (permission != null && permission.getId().equals(id)) {
            throw BizException.of(ResultCode.BIZ_SYSTEM_PERMISSION_NAME_HAS_EXIST);
        }
        // 核验父级权限是否存在
        if (!Constants.PERMISSION_TOP.equals(parentId)) {
            permission = permissionMapper.getPermissionById(parentId);
            if (permission == null) {
                throw BizException.of(ResultCode.BIZ_SYSTEM_PERMISSION_PARENT_NOT_EXIST);
            }
        }*/
    }

    /**
     * 新增权限参数核验
     *
     * @param permissionParam 权限参数
     */
    private void checkSavePermissionParam(PermissionParam permissionParam) {
       /* String name = permissionParam.getName();
        String parentId = permissionParam.getParentId();
        // 核验权限名称是否存在，不同层级下可拥有相同的名称
        Permission permission = permissionMapper.getPermissionByNameAndParentId(name, parentId);
        if (permission != null) {
            throw BizException.of(ResultCode.BIZ_SYSTEM_PERMISSION_NAME_HAS_EXIST);
        }
        // 核验父级权限是否存在
        if (!Constants.PERMISSION_TOP.equals(parentId)) {
            permission = permissionMapper.getPermissionById(parentId);
            if (permission == null) {
                throw BizException.of(ResultCode.BIZ_SYSTEM_PERMISSION_PARENT_NOT_EXIST);
            }
        }*/
    }
}
