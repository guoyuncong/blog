package com.blog.platform.service;


import com.blog.platform.model.dto.PageDTO;
import com.blog.platform.model.dto.RoleDTO;
import com.blog.platform.model.entity.User;
import com.blog.platform.model.param.RoleParam;

import java.util.List;

public interface RoleService {

    /**
     * 新增角色
     *
     * @param roleParam 角色参数
     * @return 角色ID
     */
    String save(RoleParam roleParam);

    /**
     * 修改角色
     *
     * @param roleParam 角色参数
     */
    void update(RoleParam roleParam);

    /**
     * 删除角色
     *
     * @param roleId 角色ID
     */
    void delete(String roleId);

    /**
     * 分页查询角色列表
     *
     * @param name      角色名称
     * @param status    状态
     * @param beginTime 开始时间
     * @param endTime   结束时间
     * @param pageNo    页码
     * @param pageSize  每页显示条数
     * @return List<RoleDTO>
     */
    PageDTO<RoleDTO> list(String name, Integer status, String beginTime, String endTime, Integer pageNo, Integer pageSize);

    /**
     * 获取用户角色
     *
     * @param user bean
     * @return 角色集合
     */
    List<String> getUserRoles(User user);
}
