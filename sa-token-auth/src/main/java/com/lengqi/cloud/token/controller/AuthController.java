package com.lengqi.cloud.token.controller;

import com.lengqi.common.result.ResultCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@Slf4j
public class AuthController {

    //登录
    @PostMapping("/doLogin")
    public ResultCode doLogin(){
        return null;
    }

    //登出
    @PostMapping("/logout")
    public ResultCode logout(){
        return null;
    }
}
