package com.blog.platform.basic.util;

import com.blog.platform.model.dto.*;
import com.blog.platform.model.entity.*;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

public class DO2DTOUtil {

    /**
     * List<LinkDTO> → List<LinkDTO>
     *
     * @param links List<Link>
     * @return List<LinkDTO>
     */
    public static List<LinkDTO> linkList2DTOList(List<Link> links) {
        List<LinkDTO> linkDTOS = new ArrayList<>();
        links.forEach(link -> {
            LinkDTO linkDTO = new LinkDTO();
            BeanUtils.copyProperties(link, linkDTO);
            linkDTOS.add(linkDTO);
        });
        return linkDTOS;
    }

    /**
     * List<Role> → List<RoleDTO>
     *
     * @param roles List<Role>
     * @return List<RoleDTO>
     */
    public static List<RoleDTO> roleList2DTOList(List<Role> roles) {
        List<RoleDTO> roleDTOS = new ArrayList<>();
        roles.forEach(role -> {
            RoleDTO roleDTO = new RoleDTO();
            BeanUtils.copyProperties(role, roleDTO);
            roleDTOS.add(roleDTO);
        });
        return roleDTOS;
    }

    /**
     * List<User> → List<UserDTO>
     *
     * @param users List<User>
     * @return List<UserDTO>
     */
    public static List<UserDTO> userList2DTOList(List<User> users) {
        List<UserDTO> userDTOS = new ArrayList<>();
        users.forEach(user -> {
            UserDTO userDTO = new UserDTO();
            BeanUtils.copyProperties(user, userDTO);
            userDTOS.add(userDTO);
        });
        return userDTOS;
    }

    /**
     * List<Category> → List<CategoryDTO>
     *
     * @param categoryList List<Category>
     * @return List<CategoryDTO>
     */
    public static List<CategoryDTO> categoryList2DTOList(List<Category> categoryList) {
        List<CategoryDTO> categoryDTOS = new ArrayList<>();
        categoryList.forEach(category -> {
            CategoryDTO categoryDTO = new CategoryDTO();
            BeanUtils.copyProperties(category, categoryDTO);
            categoryDTOS.add(categoryDTO);
        });
        return categoryDTOS;
    }

    /**
     * List<Label> → List<LabelDTO>
     *
     * @param labels List<Label>
     * @return List<LabelDTO>
     */
    public static List<LabelDTO> labelList2DTOList(List<Label> labels) {
        List<LabelDTO> labelDTOS = new ArrayList<>();
        labels.forEach(label -> {
            LabelDTO labelDTO = new LabelDTO();
            BeanUtils.copyProperties(label, labelDTO);
            labelDTOS.add(labelDTO);
        });
        return labelDTOS;
    }
}
