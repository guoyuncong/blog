package com.blog.platform.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.blog.platform.basic.enums.ResultCode;
import com.blog.platform.basic.exception.BizException;
import com.blog.platform.basic.util.SecurityUtil;
import com.blog.platform.mapper.UserMapper;
import com.blog.platform.model.dto.PageDTO;
import com.blog.platform.model.dto.UserDTO;
import com.blog.platform.model.entity.User;
import com.blog.platform.model.param.UserParam;
import com.blog.platform.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;

    @Override
    public User getUserByUserName(String username) {
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<User>().eq(User::getUsername, username);
        return userMapper.selectOne(queryWrapper);
    }

    @Override
    public PageDTO<UserDTO> list(String username, Integer status, String beginTime, String endTime, Integer pageNo, Integer pageSize) {
        // 进行分页查询
        /*PageHelper.startPage(pageNo, pageSize);
        Page<User> userPage = userMapper.list(username, status, beginTime, endTime);
        PageDTO<User> userPageDTO = new PageDTO<>(userPage);
        // DTO 映射
        List<UserDTO> userDTOS = DO2DTOUtil.userList2DTOList(userPageDTO.getList());
        PageDTO<UserDTO> userDTOPageDTO = new PageDTO<>();
        BeanUtils.copyProperties(userPageDTO, userDTOPageDTO);
        userDTOPageDTO.setList(userDTOS);*/
        return null;
    }

    @Override
    public String save(UserParam userParam) {
        checkSaveUserParam(userParam);
        User user = new User();
        BeanUtil.copyProperties(userParam, user);
        // 密码加密
        user.setPassword(SecurityUtil.encryptPassword(user.getPassword()));
        // 创建者
        user.setCreateBy(SecurityUtil.getLoginUserId());
        userMapper.insert(user);
        return user.getId();
    }

    @Override
    public void update(UserParam userParam) {
        checkUpdateUserParam(userParam);
        User user = new User();
        BeanUtil.copyProperties(userParam, user);
        user.setUpdateBy(SecurityUtil.getLoginUserId());
        userMapper.updateById(user);
    }

    @Override
    public void updateStatus(UserParam userParam) {
      /*  checkUpdateStatusParam(userParam);
        User user = new User();
        BeanUtil.copyProperties(userParam, user);
        user.setUpdateBy(SecurityUtil.getLoginUserId());
        userMapper.updateStatus(user);*/
    }

    /**
     * 核验更新状态参数
     *
     * @param userParam 用户参数
     */
    private void checkUpdateStatusParam(UserParam userParam) {
        String id = userParam.getId();
        Integer status = userParam.getStatus();
        if (StrUtil.isEmpty(id) || status == null) {
            throw BizException.of(ResultCode.USER_REQUEST_FILL_PARAM_EMPTY);
        }
    }

    /**
     * 核验更新用户参数
     *
     * @param userParam 用户参数
     */
    private void checkUpdateUserParam(UserParam userParam) {
      /*  String id = userParam.getId();
        if (StrUtil.isEmpty(id)) {
            throw BizException.of(ResultCode.USER_REQUEST_FILL_PARAM_EMPTY);
        }
        String username = userParam.getUsername();
        User user = userMapper.getUserById(id);
        if (user == null) {
            throw BizException.of(ResultCode.USER_ACCOUNT_NOT_EXIST);
        }
        user = userMapper.getUserByUserName(username);
        if (user != null && ! user.getId().equals(id)) {
            throw BizException.of(ResultCode.USER_USERNAME_HAS_EXISTED);
        }*/
    }

    /**
     * 核验保存用户参数
     *
     * @param userParam 用户参数
     */
    private void checkSaveUserParam(UserParam userParam) {
      /*  String username = userParam.getUsername();
        User user = userMapper.getUserByUserName(username);
        if (user != null) {
            throw BizException.of(ResultCode.USER_USERNAME_HAS_EXISTED);
        }*/
    }
}
