package com.blog.platform.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.blog.platform.basic.util.SecurityUtil;
import com.blog.platform.mapper.LabelMapper;
import com.blog.platform.mapper.PostLabelMapper;
import com.blog.platform.model.dto.LabelDTO;
import com.blog.platform.model.entity.Label;
import com.blog.platform.model.param.LabelParam;
import com.blog.platform.service.LabelService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class LabelServiceImpl implements LabelService {

    private final LabelMapper labelMapper;

    private final PostLabelMapper postsLabelMapper;

    @Override
    public String save(LabelParam labelParam) {
        checkSaveLabelParam(labelParam);
        Label label = new Label();
        BeanUtil.copyProperties(labelParam, label);
        label.setCreateBy(SecurityUtil.getLoginUserId());
        labelMapper.insert(label);
        return label.getId();
    }

    @Override
    public void update(LabelParam labelParam) {
        checkUpdateLabelParam(labelParam);
        Label label = new Label();
        BeanUtil.copyProperties(labelParam, label);
        label.setUpdateBy(SecurityUtil.getLoginUserId());
        labelMapper.updateById(label);
    }

    @Override
    public void delete(String labelId) {
        checkDeleteLabelParam(labelId);
        labelMapper.deleteById(labelId);
    }

    @Override
    public List<LabelDTO> list(String name, String parentId, String level) {
       /* List<Label> labels = labelMapper.list(name, parentId, level);
        return DO2DTOUtil.labelList2DTOList(labels);*/
        return null;
    }

    /**
     * 核验删除分类参数
     *
     * @param labelId 标签ID
     */
    private void checkDeleteLabelParam(String labelId) {
       /* Label label = labelMapper.getLabelById(labelId);
        if (label == null) {
            throw BizException.of(ResultCode.BIZ_SYSTEM_LABEL_NOT_EXIST);
        }
        String level = label.getLevel();
        if (RelationLevel.PARENT.equals(level)) {
            List<Label> labels = labelMapper.getLabelByParentId(label.getId());
            if (CollUtil.isNotEmpty(labels)) {
                throw BizException.of(ResultCode.BIZ_SYSTEM_LABEL_HAS_CHILD);
            }
        } else {
            List<PostLabel> postsLabels = postsLabelMapper.getPostLabelByLabelId(label.getId());
            if (CollUtil.isNotEmpty(postsLabels)) {
                throw BizException.of(ResultCode.BIZ_SYSTEM_LABEL_DISTRIBUTE);
            }
        }*/
    }

    /**
     * 核验修改分类参数
     *
     * @param labelParam 分类参数
     */
    private void checkUpdateLabelParam(LabelParam labelParam) {
       /* String id = labelParam.getId();
        if (StrUtil.isEmpty(id)) {
            throw BizException.of(ResultCode.USER_REQUEST_FILL_PARAM_EMPTY);
        }
        String name = labelParam.getName();
        Label label = labelMapper.getLabelByName(name);
        if (label != null && !label.getId().equals(id)) {
            throw BizException.of(ResultCode.BIZ_SYSTEM_LABEL_NAME_HAS_EXIST);
        }
        checkLabelParentChildRelation(labelParam);*/
    }

    /**
     * 核验添加分类参数
     *
     * @param labelParam 分类参数
     */
    private void checkSaveLabelParam(LabelParam labelParam) {
      /*  String name = labelParam.getName();
        Label label = labelMapper.getLabelByName(name);
        if (label != null) {
            throw BizException.of(ResultCode.BIZ_SYSTEM_LABEL_NAME_HAS_EXIST);
        }
        checkLabelParentChildRelation(labelParam);*/
    }

    /**
     * 核验子父级分类是否正确
     *
     * @param labelParam 分类参数
     */
    private void checkLabelParentChildRelation(LabelParam labelParam) {
        /*String level = labelParam.getLevel();
        // 如果是子级分类，查找父级分类是否存在
        if (RelationLevel.CHILD.name().equals(level)) {
            String parentId = labelParam.getParentId();
            if (StrUtil.isEmpty(parentId)){
                throw BizException.of(ResultCode.USER_REQUEST_FILL_PARAM_EMPTY);
            }
            Label label = labelMapper.getLabelByIdAndLevel(parentId, RelationLevel.PARENT.name());
            if (label == null) {
                throw BizException.of(ResultCode.BIZ_SYSTEM_CATEGORY_PARENT_NOT_EXIST);
            }
        }*/
    }
}
