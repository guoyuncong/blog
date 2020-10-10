package com.blog.platform.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.blog.platform.mapper.BasicMapper;
import com.blog.platform.model.entity.Basic;
import com.blog.platform.model.param.BasicParam;
import com.blog.platform.service.BasicService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

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


}
