package com.blog.platform.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.blog.platform.basic.constants.Constants;
import com.blog.platform.basic.enums.ResultCode;
import com.blog.platform.basic.exception.BizException;
import com.blog.platform.basic.util.SecurityUtil;
import com.blog.platform.basic.util.converter.CategoryConverter;
import com.blog.platform.mapper.CategoryMapper;
import com.blog.platform.mapper.PostCategoryMapper;
import com.blog.platform.model.dto.CategoryDTO;
import com.blog.platform.model.entity.Category;
import com.blog.platform.model.entity.PostCategory;
import com.blog.platform.model.param.CategoryParam;
import com.blog.platform.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * 分类 Service-Impl
 *
 * @author: rookie
 * @date: 2020-10-10
 */
@Service
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryMapper categoryMapper;

    private final PostCategoryMapper postsCategoryMapper;

    @Override
    public String save(CategoryParam categoryParam) {
        checkSaveCategoryParam(categoryParam);
        Category category = new Category();
        BeanUtil.copyProperties(categoryParam, category);
        category.setCreateBy(SecurityUtil.getLoginUserId());
        categoryMapper.insert(category);
        return category.getId();
    }

    @Override
    public void update(CategoryParam categoryParam) {
        checkUpdateCategoryParam(categoryParam);
        Category category = new Category();
        BeanUtil.copyProperties(categoryParam, category);
        category.setUpdateBy(SecurityUtil.getLoginUserId());
        categoryMapper.updateById(category);
    }

    @Override
    public void delete(String categoryId) {
        checkDeleteCategoryParam(categoryId);
        categoryMapper.deleteById(categoryId);
    }

    @Override
    public List<CategoryDTO> list(String name, Integer level) {
        LambdaQueryWrapper<Category> queryWrapper = new LambdaQueryWrapper<Category>()
                .eq(level != null, Category::getLevel, level)
                .like(StrUtil.isNotEmpty(name), Category::getName, name)
                .orderByAsc(Category::getSort);
        List<Category> categories = categoryMapper.selectList(queryWrapper);
        List<CategoryDTO> categoryDTOS = CategoryConverter.INSTANCE.domain2Dto(categories);
        return categoryDTOS;
    }

    /**
     * 核验删除分类参数
     *
     * @param categoryId 分类ID
     */
    private void checkDeleteCategoryParam(String categoryId) {
        Category category = categoryMapper.selectById(categoryId);
        if (category == null) {
            throw BizException.of(ResultCode.BIZ_SYSTEM_CATEGORY_NOT_EXIST);
        }
        Integer level = category.getLevel();
        String id = category.getId();
        // 有下级不允许删除
        if (Constants.LEVEL_PARENT.equals(level)) {
            LambdaQueryWrapper<Category> queryWrapper = new LambdaQueryWrapper<Category>()
                    .eq(Category::getParentId, id);
            Integer count = categoryMapper.selectCount(queryWrapper);
            if (count > 0) {
                throw BizException.of(ResultCode.BIZ_SYSTEM_CATEGORY_HAS_CHILD);
            }
        } else {
            // 存在文章关联不允许删除
            LambdaQueryWrapper<PostCategory> queryWrapper = new LambdaQueryWrapper<PostCategory>()
                    .eq(PostCategory::getCategoryId, id);
            Integer count = postsCategoryMapper.selectCount(queryWrapper);
            if (count > 0) {
                throw BizException.of(ResultCode.BIZ_SYSTEM_CATEGORY_DISTRIBUTE);
            }
        }
    }

    /**
     * 核验修改分类参数
     *
     * @param categoryParam 分类参数
     */
    private void checkUpdateCategoryParam(CategoryParam categoryParam) {
        String id = categoryParam.getId();
        if (StrUtil.isEmpty(id)) {
            throw BizException.of(ResultCode.USER_REQUEST_FILL_PARAM_EMPTY);
        }
        String parentId = categoryParam.getParentId();
        if (StrUtil.isNotEmpty(parentId) && id.equals(parentId)) {
            throw BizException.of(ResultCode.USER_REQUEST_PARAM_ERROR);
        }
        String name = categoryParam.getName();
        LambdaQueryWrapper<Category> queryWrapper = new LambdaQueryWrapper<Category>()
                .eq(Category::getName, name)
                .ne(Category::getId, id);
        Integer count = categoryMapper.selectCount(queryWrapper);
        if (count > 0) {
            throw BizException.of(ResultCode.BIZ_SYSTEM_CATEGORY_NAME_HAS_EXIST);
        }
        // 核验父级
        checkCategoryParent(categoryParam);
    }

    /**
     * 核验添加分类参数
     *
     * @param categoryParam 分类参数
     */
    private void checkSaveCategoryParam(CategoryParam categoryParam) {
        String name = categoryParam.getName();
        LambdaQueryWrapper<Category> queryWrapper = new LambdaQueryWrapper<Category>().eq(Category::getName, name);
        Category category = categoryMapper.selectOne(queryWrapper);
        if (category != null) {
            throw BizException.of(ResultCode.BIZ_SYSTEM_CATEGORY_NAME_HAS_EXIST);
        }
        // 核验父级
        checkCategoryParent(categoryParam);
    }

    /**
     * 核验子父级分类是否正确
     *
     * @param categoryParam 分类参数
     */
    private void checkCategoryParent(CategoryParam categoryParam) {
        String parentId = categoryParam.getParentId();
        if (StrUtil.isNotEmpty(parentId)) {
            LambdaQueryWrapper<Category> queryWrapper = new LambdaQueryWrapper<Category>()
                    .eq(Category::getId, parentId)
                    .eq(Category::getLevel, Constants.LEVEL_PARENT);
            Integer count = categoryMapper.selectCount(queryWrapper);
            if (count == 0) {
                throw BizException.of(ResultCode.BIZ_SYSTEM_CATEGORY_PARENT_NOT_EXIST);
            }
            categoryParam.setLevel(Constants.LEVEL_CHILD);
        } else {
            categoryParam.setLevel(Constants.LEVEL_PARENT);
        }
    }
}
