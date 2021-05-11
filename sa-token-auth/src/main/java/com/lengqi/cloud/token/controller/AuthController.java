package com.lengqi.cloud.token.controller;

import cn.dev33.satoken.stp.StpUtil;
import com.lengqi.cloud.common.utils.StpUserUtil;
import com.lengqi.cloud.token.service.AuthService;
import com.lengqi.cloud.common.result.ResultVo;
import com.lengqi.cloud.common.utils.DateAndStringUtil;
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
    public ResultVo<Object> doLogin(String key, String password){

        try {
            if (DateAndStringUtil.isOneNull(key,password)){
                return ResultVo.failed("请输入用户名或密码");
            }
            return authService.doLogin(key, password);
        } catch (Exception e) {
            log.error("doLogin:"+e.getMessage());
            return ResultVo.failed("登录失败");
        }
    }

    //登出
    @PostMapping("/logout")
    public ResultVo<Object> logout(){
        try {
            return authService.logout();
        } catch (Exception e) {
            log.error("登出异常："+e.getMessage());
            return ResultVo.failed("退出登录异常");
        }
    }
}
