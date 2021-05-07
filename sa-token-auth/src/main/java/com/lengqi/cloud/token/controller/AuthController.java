package com.lengqi.cloud.token.controller;

import com.lengqi.cloud.admin.common.exception.BizException;
import com.lengqi.cloud.token.service.AuthService;
import com.lengqi.cloud.admin.common.result.ResultCode;
import com.lengqi.cloud.admin.common.result.ResultVo;
import com.lengqi.cloud.admin.common.utils.DateAndStringUtil;
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
    public ResultVo doLogin(String key, String password){

        if (DateAndStringUtil.isOneNull(key,password)){
            return ResultVo.failed("请输入用户名或密码");
        }
        return authService.doLogin(key, password);
    }

    //登出
    @PostMapping("/logout")
    public ResultVo<Object> logout(){
        return authService.logout();
    }
}
