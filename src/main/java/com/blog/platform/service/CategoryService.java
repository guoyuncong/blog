package com.blog.platform.service;

import com.blog.platform.model.dto.CategoryDTO;
import com.blog.platform.model.param.CategoryParam;

import java.util.List;

/**
 * 分类 Service
 *
 * @author: rookie
 * @date: 2020-10-10
 */
public interface CategoryService {

    /**
     * 添加分类
     *
     * @param categoryParam 分类参数
     * @return 主键ID
     */
    String save(CategoryParam categoryParam);

    /**
     * 更新分类
     *
     * @param categoryParam 分类参数
     */
    void update(CategoryParam categoryParam);

    /**
     * 删除分类
     *
     * @param categoryId 主键ID
     */
    void delete(String categoryId);

    /**
     * 查询分类列表
     *
     * @param name     分类名称
     * @param level    等级
     * @return List<Category>
     */
    List<CategoryDTO> list(String name, Integer level);
}
