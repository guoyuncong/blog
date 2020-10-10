package com.blog.platform.controller.backend;

import com.blog.platform.basic.annotation.Log;
import com.blog.platform.basic.enums.BusinessType;
import com.blog.platform.model.dto.ResultDTO;
import com.blog.platform.model.param.PermissionParam;
import com.blog.platform.service.PermissionService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

/**
 * 菜单
 *
 * @author: rookie
 * @date: 2020-10-10
 */
@RestController
@AllArgsConstructor
@RequestMapping("menu")
public class MenuController {

    private final PermissionService permissionService;

    /**
     * 添加权限
     *
     * @param permissionParam 权限参数
     * @return 结果
     */
    @PostMapping("save")
    @Log(module = "权限管理", businessType = BusinessType.SAVE)
    @PreAuthorize("@permissionCheckService.hasPermission('system:permission:save')")
    public ResponseEntity<?> save(@RequestBody PermissionParam permissionParam) {
        String id = permissionService.save(permissionParam);
        return ResponseEntity.ok(ResultDTO.ofSuccess(id));
    }

    /**
     * 修改权限
     *
     * @param permissionParam 权限参数
     * @return 结果
     */
    @PostMapping("update")
    @Log(module = "权限管理", businessType = BusinessType.UPDATE)
    @PreAuthorize("@permissionCheckService.hasPermission('system:permission:update')")
    public ResponseEntity<?> update(@RequestBody PermissionParam permissionParam) {
        permissionService.update(permissionParam);
        return ResponseEntity.ok(ResultDTO.ofSuccess());
    }

    /**
     * 删除权限
     *
     * @param permissionId 权限ID
     * @return 结果
     */
    @Log(module = "权限管理", businessType = BusinessType.DELETE)
    @PreAuthorize("@permissionCheckService.hasPermission('system:permission:delete')")
    @DeleteMapping("/{permissionId}")
    public ResponseEntity<?> delete(@PathVariable String permissionId) {
        permissionService.delete(permissionId);
        return ResponseEntity.ok(ResultDTO.ofSuccess());
    }

    
}
