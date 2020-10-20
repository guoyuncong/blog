package com.blog.platform.controller.backend;

import com.blog.platform.basic.annotation.Log;
import com.blog.platform.basic.enums.BusinessType;
import com.blog.platform.model.dto.LabelDTO;
import com.blog.platform.model.dto.ResultDTO;
import com.blog.platform.model.param.LabelParam;
import com.blog.platform.service.LabelService;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * 标签
 *
 * @author: rookie
 * @date: 2020-10-10
 */
@RestController
@AllArgsConstructor
@RequestMapping("label")
public class LabelController {

    private final LabelService labelService;

    /**
     * 添加标签
     *
     * @param labelParam 标签参数
     * @return 结果
     */
    @PostMapping
    @Log(module = "标签管理", businessType = BusinessType.SAVE)
    @PreAuthorize("@permissionCheckService.hasPermission('system:label:save')")
    public ResultDTO<String> save(@RequestBody @Valid LabelParam labelParam) {
        String id = labelService.save(labelParam);
        return ResultDTO.ofSuccess(id);
    }

    /**
     * 修改标签
     *
     * @param labelParam 标签参数
     * @return 结果
     */
    @PutMapping
    @Log(module = "标签管理", businessType = BusinessType.UPDATE)
    @PreAuthorize("@permissionCheckService.hasPermission('system:label:update')")
    public ResultDTO<Void> update(@RequestBody @Valid LabelParam labelParam) {
        labelService.update(labelParam);
        return ResultDTO.ofSuccess();
    }

    /**
     * 删除标签
     *
     * @param labelId 标签ID
     * @return 结果
     */
    @DeleteMapping("/{labelId}")
    @Log(module = "标签管理", businessType = BusinessType.DELETE)
    @PreAuthorize("@permissionCheckService.checkPermission('system:label:delete')")
    public ResultDTO delete(@PathVariable String labelId) {
        labelService.delete(labelId);
        return ResultDTO.ofSuccess();
    }

    /**
     * 查询标签列表
     *
     * @param name     分类名称
     * @param parentId 父级ID
     * @param level    等级
     * @return 结果
     */
    @GetMapping("list")
    @Log(module = "标签管理", businessType = BusinessType.QUERY)
    @PreAuthorize("@permissionCheckService.hasPermission('system:label:query')")
    public ResultDTO list(@RequestParam(required = false) String name,
                                  @RequestParam(required = false) String parentId,
                                  @RequestParam(required = false) String level) {
        List<LabelDTO> labelDTOS = labelService.list(name, parentId, level);
        return ResultDTO.ofSuccess(labelDTOS);
    }
}
