package com.blog.platform.controller.backend;

import com.blog.platform.basic.annotation.Log;
import com.blog.platform.basic.enums.BusinessType;
import com.blog.platform.model.dto.ResultDTO;
import com.blog.platform.model.param.PostParam;
import com.blog.platform.model.param.UserParam;
import com.blog.platform.service.PostService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

/**
 * 文章
 *
 * @author: rookie
 * @date: 2020-10-10
 */
@RestController
@AllArgsConstructor
@RequestMapping("post")
public class PostController {

    private final PostService postService;

    /**
     * 文章
     *
     * @param postParam 文章请求参数
     * @return 结果
     */
    @PostMapping
    @Log(module = "文章管理", businessType = BusinessType.SAVE)
    @PreAuthorize("@permissionCheckService.hasPermission('system:post:save')")
    public ResponseEntity<?> save(@RequestBody PostParam postParam) {
        String postId = postService.save(postParam);
        return new ResponseEntity<>(ResultDTO.ofSuccess(postId), HttpStatus.OK);
    }


}
