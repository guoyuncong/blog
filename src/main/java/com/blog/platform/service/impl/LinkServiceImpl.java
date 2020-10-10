package com.blog.platform.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.blog.platform.basic.util.SecurityUtil;
import com.blog.platform.mapper.LinkMapper;
import com.blog.platform.model.dto.LinkDTO;
import com.blog.platform.model.dto.PageDTO;
import com.blog.platform.model.entity.Link;
import com.blog.platform.model.param.LinkParam;
import com.blog.platform.service.LinkService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class LinkServiceImpl implements LinkService {

    private final LinkMapper linkMapper;

    @Override
    public String save(LinkParam linkParam) {
        checkSaveLinkParam(linkParam);
        Link link = new Link();
        BeanUtil.copyProperties(linkParam, link);
        link.setCreateBy(SecurityUtil.getLoginUserId());
        linkMapper.insert(link);
        return link.getId();
    }

    @Override
    public void update(LinkParam linkParam) {
        checkUpdateLinkParam(linkParam);
        Link link = new Link();
        BeanUtil.copyProperties(linkParam, link);
        link.setUpdateBy(SecurityUtil.getLoginUserId());
        linkMapper.updateById(link);
    }

    @Override
    public void delete(String linkId) {
        checkDeleteLinkParam(linkId);
        linkMapper.deleteById(linkId);
    }

    @Override
    public PageDTO<LinkDTO> list(String name, Integer status, String type, Integer pageNo, Integer pageSize) {
      /*  // 进行分页查询
        PageHelper.startPage(pageNo, pageSize);
        Page<Link> list = linkMapper.list(name, status, type);
        PageDTO<Link> pageLink = new PageDTO<>(list);
        // DTO 映射
        List<LinkDTO> linkDTOS = DO2DTOUtil.linkList2DTOList(pageLink.getList());
        PageDTO<LinkDTO> pageLinkDTO = new PageDTO<>();
        BeanUtils.copyProperties(pageLink, pageLinkDTO);
        pageLinkDTO.setList(linkDTOS);*/
        return null;
    }

    /**
     * 核验删除链接参数
     *
     * @param linkId 链接ID
     */
    private void checkDeleteLinkParam(String linkId) {
        /*Link link = linkMapper.getLinkById(linkId);
        if (link == null) {
            throw BizException.of(ResultCode.BIZ_SYSTEM_LINK_NOT_EXIST);
        }*/
    }

    /**
     * 核验更新链接参数
     *
     * @param linkParam 链接参数
     */
    private void checkUpdateLinkParam(LinkParam linkParam) {
       /* String id = linkParam.getId();
        if (StrUtil.isEmpty(id)) {
            throw BizException.of(ResultCode.USER_REQUEST_FILL_PARAM_EMPTY);
        }
        if (linkParam.isExternalLink() && StrUtil.isEmpty(linkParam.getUrl())) {
            throw BizException.of(ResultCode.USER_REQUEST_FILL_PARAM_EMPTY);
        }
        Link link = linkMapper.getLinkById(id);
        if (link == null) {
            throw BizException.of(ResultCode.BIZ_SYSTEM_LINK_NOT_EXIST);
        }
        link = linkMapper.getLinkByName(link.getName());
        if (link != null && link.getId().equals(id)) {
            throw BizException.of(ResultCode.BIZ_SYSTEM_LINK_NAME_HAS_EXIST);
        }*/
    }

    /**
     * 核验添加链接参数
     *
     * @param linkParam 链接参数
     */
    private void checkSaveLinkParam(LinkParam linkParam) {
        /*String name = linkParam.getName();
        Link link = linkMapper.getLinkByName(name);
        if (link != null) {
            throw BizException.of(ResultCode.BIZ_SYSTEM_LINK_NAME_HAS_EXIST);
        }
        if (linkParam.isExternalLink() && StrUtil.isEmpty(linkParam.getUrl())) {
            throw BizException.of(ResultCode.USER_REQUEST_FILL_PARAM_EMPTY);
        }*/
    }
}
