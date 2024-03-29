package com.lengqi.cloud.common.gateway.utils;


import com.lengqi.cloud.common.constant.Constant;
import com.lengqi.cloud.common.utils.RedisUtil;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * 网关鉴权util (保证服务调用的安全性)
 * <br> 会生成一个token和一个次级token, 在token验证不通过时，还可以继续验证次级token
 * @author kong
 */
@Component
public class GatewayAuthUtil {

	@Resource
	private  RedisUtil redisUtil;




	/**
	 * 获取当前token, 如果不存在，则立即创建并返回
	 * @return 当前token
	 */
	public  String getToken() {
		String currentToken = (String) redisUtil.get(Constant.VAR_GATEWAY_AUTH_TOKEN_KEY);
		if(isEmpty(currentToken)) {
			refreshToken();
			currentToken = (String)redisUtil.get(Constant.VAR_GATEWAY_AUTH_TOKEN_KEY);
		}
		return currentToken;
	}

	/**
	 * 获取当前次级token, 如果不存在，则返回null
	 * @return 当前token
	 */
	public  String getLowToken() {
		return (String) redisUtil.get(Constant.VAR_GATEWAY_AUTH_LOW_TOKEN_KEY);
	}

	/**
	 * 验证一个token是否有效
	 * @param token 要验证的token
	 * @return 这个token是否有效
	 */
	public boolean verifyToken(String token) {
		// s1. 如果传入的token未空，立即返回false
		if(isEmpty(token)) {
			return false;
		}
		// s2. 验证当前token
		String currentToken = (String) redisUtil.get(Constant.VAR_GATEWAY_AUTH_TOKEN_KEY);
		if(isEmpty(currentToken) == false && currentToken.equals(token)) {
			return true;
		}
		// s3. 如果验证失败，则再次尝试验证次级token
		String currentTokenLow = (String)redisUtil.get(Constant.VAR_GATEWAY_AUTH_LOW_TOKEN_KEY);
		if(isEmpty(currentTokenLow) == false && currentTokenLow.equals(token)) {
			return true;
		}

		// s4. 如果都没有通过验证，则必定是一个无效token
		return false;
	}

	/**
	 * 刷新一次token (集群应用中请不要多个服务重复调用)
	 */
	public  void refreshToken() {
		// s1. 先将当前token写入旧token中
		String currentToken = (String) redisUtil.get(Constant.VAR_GATEWAY_AUTH_TOKEN_KEY);
		if(isEmpty(currentToken) == false) {
			redisUtil.set(Constant.VAR_GATEWAY_AUTH_LOW_TOKEN_KEY, currentToken);
		}
		// s2. 再刷新当前token
		redisUtil.set(Constant.VAR_GATEWAY_AUTH_TOKEN_KEY, createToken());
		redisUtil.set(Constant.VAR_GATEWAY_AUTH_TOKEN_REFRESH_LAST_TIME_KEY, String.valueOf(System.currentTimeMillis()));
	}



	/**
	 * 创建一个token
	 * @return token
	 */
	private static String createToken() {
		return UUID.randomUUID().toString();
	}

	/**
	 * 指定字符串是否为空
	 * @return 这个串是否为空
	 */
	private static boolean isEmpty(String str) {
		return str == null || str.equals("");
	}





}
