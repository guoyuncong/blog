package com.blog.platform.controller.backend;

import com.blog.platform.basic.constants.JwtConstants;
import com.blog.platform.model.dto.ResultDTO;
import com.blog.platform.model.dto.UserInfoDTO;
import com.blog.platform.model.param.LoginParam;
import com.blog.platform.service.LoginService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * 登录
 *
 * @author: rookie
 * @date: 2020-10-10
 */
@RestController
@AllArgsConstructor
public class LoginController {

    private final LoginService loginService;

    /**
     * 用户登录
     *
     * @param loginParam 登录参数
     * @return 结果
     */
    @PostMapping("login")
    public ResponseEntity<?> login(@RequestBody LoginParam loginParam) {
        String token = loginService.login(loginParam);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add(HttpHeaders.AUTHORIZATION, JwtConstants.TOKEN_PREFIX + token);
        return new ResponseEntity<>(ResultDTO.ofSuccess(), httpHeaders, HttpStatus.OK);
    }

    /**
     * 用户退出登录
     *
     * @return 结果
     */
    @PostMapping("logout")
    public ResponseEntity<?> logout() {
        loginService.logout();
        return ResponseEntity.ok(ResultDTO.ofSuccess());
    }

    /**
     * 获取当前登录人信息
     *
     * @return 用户信息
     */
    @GetMapping("getInfo")
    public ResponseEntity<?> getUserInfo() {
        UserInfoDTO userInfoDTO = loginService.getUserInfo();
        return ResponseEntity.ok(ResultDTO.ofSuccess(userInfoDTO));
    }

}
