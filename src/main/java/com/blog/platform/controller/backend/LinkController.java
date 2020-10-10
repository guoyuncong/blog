package com.blog.platform.controller.backend;

import com.blog.platform.basic.annotation.Log;
import com.blog.platform.basic.enums.BusinessType;
import com.blog.platform.model.dto.LabelDTO;
import com.blog.platform.model.dto.LinkDTO;
import com.blog.platform.model.dto.PageDTO;
import com.blog.platform.model.dto.ResultDTO;
import com.blog.platform.model.param.LinkParam;
import com.blog.platform.service.LinkService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * 链接
 *
 * @author: rookie
 * @date: 2020-10-10
 */
@RestController
@AllArgsConstructor
@RequestMapping("link")
public class LinkController {

    private final LinkService linkService;

    /**
     * 添加链接
     *
     * @param linkParam 链接参数
     * @return 结果
     */
    @PostMapping("save")
    @Log(module = "链接管理", businessType = BusinessType.SAVE)
    @PreAuthorize("@permissionCheckService.hasPermission('system:link:save')")
    public ResponseEntity<?> save(@RequestBody @Valid LinkParam linkParam) {
        String id = linkService.save(linkParam);
        return ResponseEntity.ok(ResultDTO.ofSuccess(id));
    }

    /**
     * 修改链接
     *
     * @param linkParam 链接参数
     * @return 结果
     */
    @PostMapping("update")
    @Log(module = "链接管理", businessType = BusinessType.UPDATE)
    @PreAuthorize("@permissionCheckService.hasPermission('system:link:update')")
    public ResponseEntity<?> update(@RequestBody @Valid LinkParam linkParam) {
       linkService.update(linkParam);
        return ResponseEntity.ok(ResultDTO.ofSuccess());
    }

    /**
     * 删除链接
     *
     * @param linkId 链接ID
     * @return 结果
     */
    @DeleteMapping("/{linkId}")
    @Log(module = "链接管理", businessType = BusinessType.DELETE)
    @PreAuthorize("@permissionCheckService.checkPermission('system:link:delete')")
    public ResponseEntity<?> delete(@PathVariable String linkId) {
        linkService.delete(linkId);
        return ResponseEntity.ok(ResultDTO.ofSuccess());
    }

    /**
     * 查询链接列表
     *
     * @param name 链接名称
     * @return 结果
     */
    @GetMapping("list")
    @Log(module = "链接管理", businessType = BusinessType.QUERY)
    @PreAuthorize("@permissionCheckService.hasPermission('system:link:query')")
    public ResponseEntity<?> list(@RequestParam(required = false) String name,
                                  @RequestParam(required = false) Integer status,
                                  @RequestParam(required = false) String type,
                                  @RequestParam(required = false, defaultValue = "1") Integer pageNo,
                                  @RequestParam(required = false, defaultValue = "10") Integer pageSize) {
        PageDTO<LinkDTO> linkDTOS = linkService.list(name, status, type, pageNo, pageSize);
        return ResponseEntity.ok(ResultDTO.ofSuccess(linkDTOS));
    }
}
