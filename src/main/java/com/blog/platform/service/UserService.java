package com.blog.platform.service;


import com.blog.platform.model.dto.PageDTO;
import com.blog.platform.model.dto.UserDTO;
import com.blog.platform.model.entity.User;
import com.blog.platform.model.param.UserParam;

public interface UserService {

    /**
     * 新增用户
     *
     * @param userParam 用户参数
     * @return 主键ID
     */
    String save(UserParam userParam);

    /**
     * 修改用户
     *
     * @param userParam 用户参数
     */
    void update(UserParam userParam);

    /**
     * 更改用户状态
     *
     * @param userParam 用户参数
     */
    void updateStatus(UserParam userParam);

    /**
     * 根据用户名获取用户信息
     *
     * @param username 用户名
     * @return bean
     */
    User getUserByUserName(String username);

    /**
     * 分页查询用户
     *
     * @param username  登录名
     * @param status    状态
     * @param beginTime 开始时间
     * @param endTime   结束时间
     * @param pageNo    页码
     * @param pageSize  每页显示条数
     * @return PageDTO<UserDTO>
     */
    PageDTO<UserDTO> list(String username, Integer status, String beginTime, String endTime, Integer pageNo, Integer pageSize);

}
