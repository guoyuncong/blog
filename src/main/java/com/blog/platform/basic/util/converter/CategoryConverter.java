package com.blog.platform.basic.util.converter;


import com.blog.platform.model.dto.CategoryDTO;
import com.blog.platform.model.entity.Category;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * Category 转换类
 * @author: rookie
 * @date: 2020-10-16
 */
@Mapper
public interface CategoryConverter {

    CategoryConverter INSTANCE = Mappers.getMapper(CategoryConverter.class);

    /**
     * Category -> CategoryDTO
     * @param category
     * @return
     */
    CategoryDTO domain2Dto(Category category);

    List<CategoryDTO> domain2Dto(List<Category> categories);

}
