package com.blog.platform.controller.backend;

import com.blog.platform.basic.annotation.Log;
import com.blog.platform.basic.enums.BusinessType;
import com.blog.platform.model.dto.CategoryDTO;
import com.blog.platform.model.dto.ResultDTO;
import com.blog.platform.model.param.CategoryParam;
import com.blog.platform.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
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
    @PostMapping("save")
    @Log(module = "分类管理", businessType = BusinessType.SAVE)
    @PreAuthorize("@permissionCheckService.hasPermission('system:category:save')")
    public ResponseEntity<?> save(@RequestBody @Valid CategoryParam categoryParam) {
        String id = categoryService.save(categoryParam);
        return ResponseEntity.ok(ResultDTO.ofSuccess(id));
    }

    /**
     * 修改分类
     *
     * @param categoryParam 分类参数
     * @return 结果
     */
    @PutMapping("update")
    @Log(module = "分类管理", businessType = BusinessType.UPDATE)
    @PreAuthorize("@permissionCheckService.hasPermission('system:category:update')")
    public ResponseEntity<?> update(@RequestBody @Valid CategoryParam categoryParam) {
        categoryService.update(categoryParam);
        return ResponseEntity.ok(ResultDTO.ofSuccess());
    }

    /**
     * 删除分类
     *
     * @param categoryId 分类ID
     * @return 结果
     */
    @DeleteMapping("/{categoryId}")
    @Log(module = "分类管理", businessType = BusinessType.DELETE)
    @PreAuthorize("@permissionCheckService.checkPermission('system:category:delete')")
    public ResponseEntity<?> delete(@PathVariable String categoryId) {
        categoryService.delete(categoryId);
        return ResponseEntity.ok(ResultDTO.ofSuccess());
    }

    /**
     * 查询分类列表
     *
     * @param name     分类名称
     * @param parentId 父级ID
     * @param level    等级
     * @return 结果
     */
    @GetMapping("list")
    @Log(module = "分类管理", businessType = BusinessType.QUERY)
    @PreAuthorize("@permissionCheckService.hasPermission('system:category:query')")
    public ResponseEntity<?> list(@RequestParam(required = false) String name,
                                  @RequestParam(required = false) String parentId,
                                  @RequestParam(required = false) String level) {
        List<CategoryDTO> categoryDTOS = categoryService.list(name, parentId, level);
        return ResponseEntity.ok(ResultDTO.ofSuccess(categoryDTOS));
    }
}
