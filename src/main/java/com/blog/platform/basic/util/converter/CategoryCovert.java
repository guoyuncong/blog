package com.blog.platform.basic.util.converter;


import com.blog.platform.model.dto.CategoryDTO;
import com.blog.platform.model.entity.Category;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * Category 转换类
 * @author: rookie
 * @date: 2020-10-16
 */
@Mapper
public interface CategoryCovert {

    CategoryCovert INSTANCE = Mappers.getMapper(CategoryCovert.class);

    /**
     *
     * @param category
     * @return
     */
    @Mappings({
            @Mapping(source = "birthday", target = "birth"),
            @Mapping(source = "birthday", target = "birthDateFormat", dateFormat = "yyyy-MM-dd HH:mm:ss"),
            @Mapping(target = "birthExpressionFormat", expression = "java(org.apache.commons.lang3.time.DateFormatUtils.format(person.getBirthday(),\"yyyy-MM-dd HH:mm:ss\"))"),
            @Mapping(source = "user.age", target = "age"),
            @Mapping(target = "email", ignore = true)
    })
    CategoryDTO domain2Dto(Category category);

    List<CategoryDTO> domain2Dto(List<Category> categories);

}
