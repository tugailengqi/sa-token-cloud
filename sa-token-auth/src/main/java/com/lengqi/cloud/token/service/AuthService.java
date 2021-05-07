package com.lengqi.cloud.token.service;

import com.lengqi.cloud.admin.common.exception.BizException;
import com.lengqi.cloud.admin.common.result.ResultCode;
import com.lengqi.cloud.admin.common.result.ResultVo;
import com.lengqi.cloud.admin.common.utils.DateAndStringUtil;
import com.lengqi.cloud.admin.feign.SysUserClient;
import com.lengqi.cloud.admin.vo.SysUserVO;
import com.lengqi.cloud.user.entity.SysUser;
import jdk.management.resource.ResourceContext;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class AuthService {

    @Resource
    private SysUserClient sysUserClient;

    public ResultVo doLogin(String key, String password){
        if (DateAndStringUtil.isOneNull(key,password)){
            throw new BizException("请输入用户名或密码");
        }
        return sysUserClient.selectUser(key, password);
    }
}
