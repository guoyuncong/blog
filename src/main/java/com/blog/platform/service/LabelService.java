package com.blog.platform.service;

import com.blog.platform.model.dto.LabelDTO;
import com.blog.platform.model.param.LabelParam;

import java.util.List;

public interface LabelService {

    /**
     * 添加分类
     *
     * @param labelParam 分类参数
     * @return 主键ID
     */
    String save(LabelParam labelParam);

    /**
     * 更新分类
     *
     * @param labelParam 分类参数
     */
    void update(LabelParam labelParam);

    /**
     * 删除分类
     *
     * @param labelId 主键ID
     */
    void delete(String labelId);

    /**
     * 查询分类列表
     *
     * @param name     分类名称
     * @param parentId 父级ID
     * @param level    等级
     * @return List<LabelDTO>
     */
    List<LabelDTO> list(String name, String parentId, String level);
}
