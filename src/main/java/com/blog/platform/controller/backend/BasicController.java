package com.blog.platform.controller.backend;

import com.blog.platform.basic.annotation.Log;
import com.blog.platform.basic.enums.BusinessType;
import com.blog.platform.model.dto.ResultDTO;
import com.blog.platform.model.param.BasicParam;
import com.blog.platform.model.param.CategoryParam;
import com.blog.platform.service.BasicService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * 博客基本信息
 *
 * @author: rookie
 * @date: 2020-10-10
 */
@RestController
@AllArgsConstructor
@RequestMapping("basic")
public class BasicController {

    private final BasicService basicService;

    /**
     * 添加基本信息
     *
     * @param basicParam 基本信息参数
     * @return 结果
     */
    @PostMapping("save")
    @Log(module = "博客基本信息管理", businessType = BusinessType.SAVE)
    @PreAuthorize("@permissionCheckService.hasPermission('system:basic:save')")
    public ResponseEntity<?> save(@RequestBody @Valid BasicParam basicParam) {
        String id = basicService.save(basicParam);
        return ResponseEntity.ok(ResultDTO.ofSuccess(id));
    }
}
