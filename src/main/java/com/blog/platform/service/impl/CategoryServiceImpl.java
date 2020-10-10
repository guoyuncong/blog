package com.blog.platform.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import com.blog.platform.basic.enums.RelationLevel;
import com.blog.platform.basic.enums.ResultCode;
import com.blog.platform.basic.exception.BizException;
import com.blog.platform.basic.util.DO2DTOUtil;
import com.blog.platform.basic.util.SecurityUtil;
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
    public List<CategoryDTO> list(String name, String parentId, String level) {
//        List<Category> categories = categoryMapper.se(name, parentId, level);
//        return DO2DTOUtil.categoryList2DTOList(categories);
        return null;
    }

    /**
     * 核验删除分类参数
     *
     * @param categoryId
     */
    private void checkDeleteCategoryParam(String categoryId) {
       /* Category category = categoryMapper.selectById(categoryId);
        if (category == null) {
            throw BizException.of(ResultCode.BIZ_SYSTEM_CATEGORY_NOT_EXIST);
        }
        String level = category.getLevel();
        if (RelationLevel.PARENT.equals(level)) {
            List<Category> categories = categoryMapper.se(category.getId());
            if (CollUtil.isNotEmpty(categories)) {
                throw BizException.of(ResultCode.BIZ_SYSTEM_CATEGORY_HAS_CHILD);
            }
        } else {
            List<PostCategory> postsCategories = postsCategoryMapper.getPostCategoryByCategoryId(category.getId());
            if (CollUtil.isNotEmpty(postsCategories)) {
                throw BizException.of(ResultCode.BIZ_SYSTEM_CATEGORY_DISTRIBUTE);
            }
        }*/
    }

    /**
     * 核验修改分类参数
     *
     * @param categoryParam 分类参数
     */
    private void checkUpdateCategoryParam(CategoryParam categoryParam) {
       /* String id = categoryParam.getId();
        if (StrUtil.isEmpty(id)) {
            throw BizException.of(ResultCode.USER_REQUEST_FILL_PARAM_EMPTY);
        }
        String name = categoryParam.getName();
        Category category = categoryMapper.getCategoryByName(name);
        if (category != null && !category.getId().equals(id)) {
            throw BizException.of(ResultCode.BIZ_SYSTEM_CATEGORY_NAME_HAS_EXIST);
        }
        checkCategoryParentChildRelation(categoryParam);*/
    }

    /**
     * 核验添加分类参数
     *
     * @param categoryParam 分类参数
     */
    private void checkSaveCategoryParam(CategoryParam categoryParam) {
      /*  String name = categoryParam.getName();
        Category category = categoryMapper.getCategoryByName(name);
        if (category != null) {
            throw BizException.of(ResultCode.BIZ_SYSTEM_CATEGORY_NAME_HAS_EXIST);
        }
        checkCategoryParentChildRelation(categoryParam);*/
    }

    /**
     * 核验子父级分类是否正确
     *
     * @param categoryParam 分类参数
     */
    private void checkCategoryParentChildRelation(CategoryParam categoryParam) {
       /* String level = categoryParam.getLevel();
        // 如果是子级分类，查找父级分类是否存在
        if (RelationLevel.CHILD.name().equals(level)) {
            String parentId = categoryParam.getParentId();
            if (StrUtil.isEmpty(parentId)){
                throw BizException.of(ResultCode.USER_REQUEST_FILL_PARAM_EMPTY);
            }
            Category category = categoryMapper.getCategoryByIdAndLevel(parentId, RelationLevel.PARENT.name());
            if (category == null) {
                throw BizException.of(ResultCode.BIZ_SYSTEM_CATEGORY_PARENT_NOT_EXIST);
            }
        }*/
    }
}
