package com.blog.platform.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.blog.platform.basic.util.SecurityUtil;
import com.blog.platform.mapper.RoleMapper;
import com.blog.platform.mapper.UserRoleMapper;
import com.blog.platform.model.dto.PageDTO;
import com.blog.platform.model.dto.RoleDTO;
import com.blog.platform.model.entity.Role;
import com.blog.platform.model.entity.User;
import com.blog.platform.model.param.RoleParam;
import com.blog.platform.service.RoleService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RoleServiceImpl implements RoleService {

    private final RoleMapper roleMapper;

    private final UserRoleMapper userRoleMapper;

    @Override
    public String save(RoleParam roleParam) {
        // 核验参数
        checkSaveRoleParam(roleParam);
        Role role = new Role();
        BeanUtil.copyProperties(roleParam, role);
        role.setCreateBy(SecurityUtil.getLoginUserId());
        roleMapper.insert(role);
        return role.getId();
    }

    @Override
    public void update(RoleParam roleParam) {
        // 核验参数
        checkEditRoleParam(roleParam);
        Role role = new Role();
        BeanUtil.copyProperties(roleParam, role);
        role.setUpdateBy(SecurityUtil.getLoginUserId());
        roleMapper.updateById(role);
    }

    @Override
    public void delete(String roleId) {
        // 核验参数
        checkDeleteRoleParam(roleId);
        roleMapper.deleteById(roleId);
    }

    @Override
    public PageDTO<RoleDTO> list(String name, Integer status, String beginTime, String endTime, Integer pageNo, Integer pageSize) {
       /*  // 进行分页查询
        PageHelper.startPage(pageNo, pageSize);
        Page<Role> list = roleMapper.list(name, status, beginTime, endTime);
        PageDTO<Role> pageRoles = new PageDTO<>(list);
        // DTO 映射
        List<RoleDTO> roleDTOS = DO2DTOUtil.roleList2DTOList(pageRoles.getList());
        PageDTO<RoleDTO> pageRoleDTO = new PageDTO<>();
        BeanUtils.copyProperties(pageRoles, pageRoleDTO);
        pageRoleDTO.setList(roleDTOS);*/
        return null;
    }

    @Override
    public List<String> getUserRoles(User user) {
      /*  List<String> roles = new ArrayList<>();
        if (user.isAdmin()) {
            roles.add(Constants.ROLE_ADMIN);
        } else {
            roles.addAll(userRoleMapper.getRoleMarkByUserId(user.getId()));
        }
        return roles;*/
        return null;
    }

    /**
     * 删除角色-核验参数
     *
     * @param roleId 角色ID
     */
    private void checkDeleteRoleParam(String roleId) {
       /* Role role = roleMapper.getRoleById(roleId);
        if (role == null) {
            throw BizException.of(ResultCode.BIZ_SYSTEM_ROLE_NOT_EXIST);
        }
        List<UserRole> userRoles = userRoleMapper.getUserRoleByRoleId(roleId);
        if (CollUtil.isNotEmpty(userRoles)) {
            throw BizException.of(ResultCode.BIZ_SYSTEM_ROLE_HAS_DISTRIBUTE);
        }*/
    }

    /**
     * 修改角色-核验参数
     *
     * @param roleParam 角色参数
     */
    private void checkEditRoleParam(RoleParam roleParam) {
       /* String id = roleParam.getId();
        String name = roleParam.getName();
        if (StrUtil.isEmpty(id)) {
            throw BizException.of(ResultCode.USER_REQUEST_PARAM_ERROR);
        }
        Role role = roleMapper.getRoleById(id);
        if (role == null) {
            throw BizException.of(ResultCode.BIZ_SYSTEM_ROLE_NOT_EXIST);
        }
        role = roleMapper.getRoleByName(name);
        if (role != null && ! role.getId().equals(id)) {
            throw BizException.of(ResultCode.BIZ_SYSTEM_EXECUTE_ERROR);
        }*/
    }

    /**
     * 添加角色核验参数
     *
     * @param roleParam 角色参数
     */
    private void checkSaveRoleParam(RoleParam roleParam) {
       /* String name = roleParam.getName();
        Role role = roleMapper.getRoleByName(name);
        if (role != null) {
            throw BizException.of(ResultCode.BIZ_SYSTEM_ROLE_NAME_HAS_EXIST);
        }*/
    }
}
