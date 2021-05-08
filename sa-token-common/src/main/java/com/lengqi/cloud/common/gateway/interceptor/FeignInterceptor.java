//package com.lengqi.cloud.common.gateway.interceptor;
//
//import com.lengqi.cloud.common.gateway.utils.GatewayAuthUtil;
//import feign.RequestInterceptor;
//import feign.RequestTemplate;
//import org.springframework.stereotype.Component;
//
//import javax.annotation.Resource;
//
//@Component
//public class FeignInterceptor implements RequestInterceptor{
//
//    @Resource
//    private GatewayAuthUtil gatewayAuthUtil;
//    @Override
//    public void apply(RequestTemplate requestTemplate) {
//        requestTemplate.header("REQUEST_TOKEN_KEY",gatewayAuthUtil.getToken());
//    }
//}
