package com.blog.platform.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.StrUtil;
import com.blog.platform.basic.enums.ResultCode;
import com.blog.platform.basic.exception.BizException;
import com.blog.platform.mapper.BasicMapper;
import com.blog.platform.model.entity.Basic;
import com.blog.platform.model.param.BasicParam;
import com.blog.platform.service.BasicService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * 博客基本信息 Service-Impl
 *
 * @author: rookie
 * @date: 2020-10-10
 */
@Service
@AllArgsConstructor
public class BasicServiceImpl implements BasicService {

    private final BasicMapper basicMapper;

    @Override
    public String save(BasicParam basicParam) {
        Basic basic = new Basic();
        BeanUtil.copyProperties(basicParam, basic);
        basicMapper.insert(basic);
        return basic.getId();
    }

    @Override
    public void update(BasicParam basicParam) {
        // 核验参数
        checkBasicUpdateParam(basicParam);
        Basic basic = new Basic();
        BeanUtil.copyProperties(basicParam, basic);
        basicMapper.updateById(basic);
    }

    /**
     * 核验更新基本信息参数
     *
     * @param basicParam 基本信息参数
     */
    private void checkBasicUpdateParam(BasicParam basicParam) {
        String id = basicParam.getId();
        if (StrUtil.isEmpty(id)) {
            throw BizException.of(ResultCode.USER_REQUEST_FILL_PARAM_EMPTY);
        }
    }

}
