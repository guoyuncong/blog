package com.blog.platform.controller.backend;

import com.blog.platform.basic.annotation.Log;
import com.blog.platform.basic.enums.BusinessType;
import com.blog.platform.model.dto.PageDTO;
import com.blog.platform.model.dto.ResultDTO;
import com.blog.platform.model.dto.RoleDTO;
import com.blog.platform.model.param.RoleParam;
import com.blog.platform.service.RoleService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

/**
 * 角色
 *
 * @author: rookie
 * @date: 2020-10-10
 */
@RestController
@AllArgsConstructor
@RequestMapping("role")
public class RoleController {

    private final RoleService roleService;

    /**
     * 添加角色
     *
     * @param roleParam 角色参数
     * @return 结果
     */
    @PostMapping("save")
    @Log(module = "角色管理", businessType = BusinessType.SAVE)
    @PreAuthorize("@permissionCheckService.hasPermission('system:role:save')")
    public ResponseEntity<?> save(@RequestBody RoleParam roleParam) {
        String id = roleService.save(roleParam);
        return ResponseEntity.ok(ResultDTO.ofSuccess(id));
    }

    /**
     * 修改角色
     *
     * @param roleParam 角色参数
     * @return 结果
     */
    @PutMapping("update")
    @Log(module = "角色管理", businessType = BusinessType.UPDATE)
    @PreAuthorize("@permissionCheckService.hasPermission('system:role:update')")
    public ResponseEntity<?> update(@RequestBody RoleParam roleParam) {
        roleService.update(roleParam);
        return ResponseEntity.ok(ResultDTO.ofSuccess());
    }

    /**
     * 删除角色
     *
     * @param roleId 角色ID
     * @return 结果
     */
    @DeleteMapping("/{roleId}")
    @Log(module = "角色管理", businessType = BusinessType.DELETE)
    @PreAuthorize("@permissionCheckService.checkPermission('system:role:delete')")
    public ResponseEntity<?> delete(@PathVariable String roleId) {
        roleService.delete(roleId);
        return ResponseEntity.ok(ResultDTO.ofSuccess());
    }

    /**
     * 分页查询角色列表
     *
     * @param name      角色名称
     * @param status    状态
     * @param beginTime 开始时间
     * @param endTime   结束时间
     * @param pageNo    页码
     * @param pageSize  每页显示条数
     * @return 结果
     */
    @GetMapping("list")
    @Log(module = "角色管理", businessType = BusinessType.QUERY)
    @PreAuthorize("@permissionCheckService.hasPermission('system:role:query')")
    public ResponseEntity<?> list(@RequestParam(required = false) String name,
                                  @RequestParam(required = false) Integer status,
                                  @RequestParam(required = false) String beginTime,
                                  @RequestParam(required = false) String endTime,
                                  @RequestParam(required = false, defaultValue = "10") Integer pageSize,
                                  @RequestParam(required = false, defaultValue = "1") Integer pageNo) {
        PageDTO<RoleDTO> roleDTOS = roleService.list(name, status, beginTime, endTime, pageNo, pageSize);
        return ResponseEntity.ok(ResultDTO.ofSuccess(roleDTOS));
    }


}
