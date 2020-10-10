package com.blog.platform.service;


import com.blog.platform.model.dto.LinkDTO;
import com.blog.platform.model.dto.PageDTO;
import com.blog.platform.model.param.LinkParam;

public interface LinkService {

    /**
     * 新增链接
     *
     * @param linkParam 链接参数
     * @return 主键ID
     */
    String save(LinkParam linkParam);

    /**
     * 更新链接
     *
     * @param linkParam 链接参数
     * @return 主键ID
     */
    void update(LinkParam linkParam);

    /**
     * 删除链接
     *
     * @param linkId 主键ID
     */
    void delete(String linkId);

    /**
     * 分页查询链接
     *
     * @param name     名称
     * @param status   状态
     * @param type     类型
     * @param pageNo   页码
     * @param pageSize 每页显示条数
     * @return PageDTO<LinkDTO>
     */
    PageDTO<LinkDTO> list(String name, Integer status, String type, Integer pageNo, Integer pageSize);
}
