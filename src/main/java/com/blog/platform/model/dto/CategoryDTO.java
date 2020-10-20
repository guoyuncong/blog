package com.blog.platform.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * 分类
 *
 * @author: rookie
 * @date: 2020-10-10
 */
@Data
public class CategoryDTO extends EntityDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    private String id;

    /**
     * 类别名称
     */
    private String name;

    /**
     * 类别等级
     */
    @JsonIgnore
    private String level;

    /**
     * 父类别id
     */
    @JsonIgnore
    private String parentId;

    /**
     * 排序
     */
    @JsonIgnore
    private Integer sort;
}
