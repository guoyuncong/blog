package com.blog.platform.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.blog.platform.model.entity.Menu;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

/**
 * 权限表（菜单表）
 *
 * @author: rookie
 * @date: 2020-10-10
 */
@Repository
public interface MenuMapper extends BaseMapper<Menu> {

    /**
     * 获取用户所有权限，去重
     *
     * @param userId 用户ID
     * @return 权限标识集合
     */
    List<String> getMenuMarksByUserId(@Param("userId") String userId);
}
