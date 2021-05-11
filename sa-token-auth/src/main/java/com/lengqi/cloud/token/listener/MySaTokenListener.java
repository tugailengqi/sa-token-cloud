package com.lengqi.cloud.token.listener;

import cn.dev33.satoken.listener.SaTokenListener;
import cn.dev33.satoken.stp.SaLoginModel;
import com.lengqi.cloud.admin.feign.SysUserClient;
import com.lengqi.cloud.admin.vo.SysUserVO;
import com.lengqi.cloud.common.result.ResultVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;

@Component
@Slf4j
public class MySaTokenListener implements SaTokenListener {

    @Resource
    private SysUserClient sysUserClient;

    @Override
    public void doLogin(String loginKey, Object loginId, SaLoginModel saLoginModel) {

    }

    @Override
    public void doLogout(String loginKey, Object loginId, String tokenValue) {

    }
    /** 每次被踢下线时触发 */
    @Override
    public void doLogoutByLoginId(String s, Object o, String s1, String s2) {

    }

    /** 每次被顶下线时触发 */
    @Override
    public void doReplaced(String s, Object o, String s1, String s2) {

    }

    /** 每次被封禁时触发 */
    @Override
    public void doDisable(String s, Object o, long l) {

    }

    /** 每次被解封时触发 */
    @Override
    public void doUntieDisable(String s, Object o) {

    }

    /** 每次创建Session时触发 */
    @Override
    public void doCreateSession(String s) {

    }

    /** 每次注销Session时触发 */
    @Override
    public void doLogoutSession(String s) {

    }
}
