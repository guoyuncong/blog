package com.blog.platform.controller.backend;

import com.blog.platform.basic.annotation.Log;
import com.blog.platform.basic.enums.BusinessType;
import com.blog.platform.model.dto.PageDTO;
import com.blog.platform.model.dto.ResultDTO;
import com.blog.platform.model.dto.UserDTO;
import com.blog.platform.model.param.UserParam;
import com.blog.platform.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

/**
 * 用户
 *
 * @author: rookie
 * @date: 2020-10-10
 */
@RestController
@AllArgsConstructor
@RequestMapping("user")
public class UserController {

    private final UserService userService;

    /**
     * 新增用户
     *
     * @param userParam 用户参数
     * @return 结果
     */
    @PostMapping
    @Log(module = "用户管理", businessType = BusinessType.SAVE)
    @PreAuthorize("@permissionCheckService.hasPermission('system:user:save')")
    public ResponseEntity<?> save(@RequestBody UserParam userParam) {
        String userId = userService.save(userParam);
        return new ResponseEntity<>(ResultDTO.ofSuccess(userId), HttpStatus.OK);
    }

    /**
     * 更新用户
     *
     * @param userParam 用户参数
     * @return 结果
     */
    @PutMapping
    @Log(module = "用户管理", businessType = BusinessType.UPDATE)
    @PreAuthorize("@permissionCheckService.hasPermission('system:user:update')")
    public ResponseEntity<?> update(@RequestBody UserParam userParam) {
        userService.update(userParam);
        return ResponseEntity.ok(ResultDTO.ofSuccess());
    }

    /**
     * 更改用户状态
     *
     * @param userParam 用户参数
     * @return 结果
     */
    @PostMapping("updateStatus")
    @Log(module = "用户管理", businessType = BusinessType.UPDATE)
    @PreAuthorize("@permissionCheckService.hasPermission('system:user:update')")
    public ResponseEntity<?> updateStatus(@RequestBody UserParam userParam) {
        userService.updateStatus(userParam);
        return ResponseEntity.ok(ResultDTO.ofSuccess());
    }

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
    @GetMapping("list")
    @Log(module = "用户管理", businessType = BusinessType.QUERY)
    @PreAuthorize("@permissionCheckService.hasPermission('system:user:list')")
    public ResponseEntity<?> list(@RequestParam(required = false) String username,
                                  @RequestParam(required = false) Integer status,
                                  @RequestParam(required = false) String beginTime,
                                  @RequestParam(required = false) String endTime,
                                  @RequestParam(required = false, defaultValue = "1") Integer pageNo,
                                  @RequestParam(required = false, defaultValue = "10") Integer pageSize) {
        PageDTO<UserDTO> userDTOPage = userService.list(username, status, beginTime, endTime, pageNo, pageSize);
        return ResponseEntity.ok(ResultDTO.ofSuccess(userDTOPage));
    }

}
