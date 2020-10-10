package com.blog.platform.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;


/**
 * 角色菜单关联实体类
 *
 * @author: rookie
 * @date: 2020-10-10
 */
@Data
@TableName("role_menu")
public class RoleMenu extends Entity {

    /**
     * 主键ID
     */
    @TableId(type = IdType.ASSIGN_UUID)
    private String id;

    /**
     * 角色ID
     */
    private String roleId;

    /**
     * 权限ID
     */
    private String menuId;
}
