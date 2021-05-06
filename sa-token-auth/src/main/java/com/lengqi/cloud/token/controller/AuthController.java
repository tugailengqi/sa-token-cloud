package com.lengqi.cloud.token.controller;

import cn.hutool.core.util.StrUtil;
import com.lengqi.cloud.token.service.AuthService;
import com.lengqi.common.result.ResultCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/auth")
@Slf4j
public class AuthController {

    @Resource
    private AuthService authService;

    //登录
    @PostMapping("/doLogin")
    public ResultCode doLogin(String key,String password){

        return null;
    }

    //登出
    @PostMapping("/logout")
    public ResultCode logout(){
        return null;
    }
}
