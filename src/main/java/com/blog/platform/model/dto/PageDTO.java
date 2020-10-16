package com.blog.platform.model.dto;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

/**
 * 分页
 *
 * @author: rookie
 * @date: 2020-10-10
 */
@Data
public class PageDTO<T> implements Serializable {

    private static final long serialVersionUID = 8656597559014685635L;

    /**
     * 当前页码
     */
    private Long pageNum;

    /**
     * 当前页记录数
     */
    private Long size;

    /**
     * 总页数
     */
    private Long pages;

    /**
     * 每页记录数
     */
    private Long pageSize;

    /**
     * 总记录数
     */
    private Long total;

    /**
     * 结果集
     */
    private List<T> list;

    /**
     * 无参构造
     */
    public PageDTO() {

    }

    public PageDTO(Page<T> page) {
        this.pageNum = page.getCurrent();
        this.total = page.getTotal();
        this.pages = page.getPages();
        this.list = page.getRecords();
        this.pageSize = page.getPages();
    }
}
