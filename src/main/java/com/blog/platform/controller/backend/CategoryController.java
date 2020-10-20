package com.blog.platform.controller.backend;

import com.blog.platform.basic.annotation.Log;
import com.blog.platform.basic.enums.BusinessType;
import com.blog.platform.model.dto.CategoryDTO;
import com.blog.platform.model.dto.ResultDTO;
import com.blog.platform.model.param.CategoryParam;
import com.blog.platform.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import javax.validation.Valid;

/**
 * 分类
 *
 * @author: rookie
 * @date: 2020-10-10
 */
@RestController
@AllArgsConstructor
@RequestMapping("category")
public class CategoryController {

    private final CategoryService categoryService;

    /**
     * 添加分类
     *
     * @param categoryParam 分类参数
     * @return 结果
     */
    @PostMapping
    @Log(module = "分类管理", businessType = BusinessType.SAVE)
    @PreAuthorize("@permissionCheckService.hasPermission('system:category:save')")
    public ResultDTO<String> save(@RequestBody @Valid CategoryParam categoryParam) {
        String id = categoryService.save(categoryParam);
        return ResultDTO.ofSuccess(id);
    }

    /**
     * 修改分类
     *
     * @param categoryParam 分类参数
     * @return 结果
     */
    @PutMapping
    @Log(module = "分类管理", businessType = BusinessType.UPDATE)
    @PreAuthorize("@permissionCheckService.hasPermission('system:category:update')")
    public ResultDTO<Void> update(@RequestBody @Valid CategoryParam categoryParam) {
        categoryService.update(categoryParam);
        return ResultDTO.ofSuccess();
    }

    /**
     * 删除分类
     *
     * @param categoryId 分类ID
     * @return 结果
     */
    @DeleteMapping("{categoryId}")
    @Log(module = "分类管理", businessType = BusinessType.DELETE)
    @PreAuthorize("@permissionCheckService.hasPermission('system:category:delete')")
    public ResultDTO<Void> delete(@PathVariable String categoryId) {
        categoryService.delete(categoryId);
        return ResultDTO.ofSuccess();
    }

    /**
     * 查询分类列表
     *
     * @param name     分类名称
     * @param level    等级
     * @return 结果
     */
    @GetMapping("list")
    @Log(module = "分类管理", businessType = BusinessType.QUERY)
    @PreAuthorize("@permissionCheckService.hasPermission('system:category:query')")
    public ResultDTO<List<CategoryDTO>> list(@RequestParam(required = false) String name,
                                             @RequestParam(required = false) Integer level) {
        List<CategoryDTO> categoryDTOS = categoryService.list(name, level);
        return ResultDTO.ofSuccess(categoryDTOS);
    }
}
