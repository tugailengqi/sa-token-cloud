package com.lengqi.cloud.admin.interceptor;

import cn.dev33.satoken.interceptor.SaAnnotationInterceptor;
import cn.dev33.satoken.interceptor.SaRouteInterceptor;
import cn.dev33.satoken.router.SaRouterUtil;
import com.lengqi.cloud.common.utils.StpUserUtil;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

@Configuration
public class SaTokenConfigure implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(new SaRouteInterceptor(((request, response, handler) -> {
            //登录验证
            SaRouterUtil.match("/**","/sys_user/selectUser", StpUserUtil::checkLogin);

            // 登录验证 -- 排除多个路径
//            SaRouterUtil.match(Arrays.asList("/**"), Arrays.asList("/user/doLogin", "/user/reg"), () -> StpUtil.checkLogin());

        }))).addPathPatterns("/**");
    }
}
