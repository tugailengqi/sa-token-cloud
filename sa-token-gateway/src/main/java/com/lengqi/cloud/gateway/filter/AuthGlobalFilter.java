package com.lengqi.cloud.gateway.filter;

import cn.hutool.core.util.StrUtil;
import com.lengqi.cloud.common.constant.Constant;
import com.lengqi.cloud.common.gateway.propertis.SaTokenProperties;
import com.lengqi.cloud.common.gateway.utils.GatewayAuthUtil;
import com.lengqi.cloud.common.utils.RedisUtil;
import com.lengqi.cloud.gateway.config.WhiteListConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import javax.annotation.Resource;
import java.util.List;
import java.util.Set;

/**
 * 配置全局过滤器，在过滤器上进行token添加token
 */
@Component
@Slf4j
public class AuthGlobalFilter implements GlobalFilter, Ordered {

    @Resource
    private SaTokenProperties properties;

    @Resource
    private RedisUtil redisUtil;

    @Resource
    private WhiteListConfig whiteListConfig;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();
        ServerHttpResponse response = exchange.getResponse();

        //过滤白名单
        String path = request.getURI().getPath();
        for (String url : whiteListConfig.getUrls()) {
            if (url.contains(path)){
                return chain.filter(exchange);
            }
        }
        String saToken = request.getHeaders().getFirst("saToken");
        if (StrUtil.isBlank(saToken) || StringUtils.isEmpty(saToken)) {
            response.setStatusCode(HttpStatus.UNAUTHORIZED);
            return response.setComplete();
        }


        Integer uid = (Integer) redisUtil.get("satoken:sysUser:token:" + saToken);
        if (StringUtils.isEmpty(uid) || uid == 0){
            log.info("token不正确");
            response.setStatusCode(HttpStatus.UNAUTHORIZED);
            return response.setComplete();
        }
        ServerHttpRequest build = request.mutate().header(Constant.SA_TOKEN, saToken).build();
        exchange.mutate().request(build).build();
        properties.setOnlyFetchByGateway(true);
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
