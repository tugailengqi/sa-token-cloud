package com.lengqi.cloud.token.interceptor;


import com.lengqi.cloud.common.constant.Constant;
import com.lengqi.cloud.common.utils.StpUserUtil;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FeignInterceptor implements RequestInterceptor {


    @Override
    public void apply(RequestTemplate requestTemplate) {
        requestTemplate.header(Constant.SA_TOKEN, StpUserUtil.getTokenValue());
    }
}
