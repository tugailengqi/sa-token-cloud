package com.lengqi.cloud.token.service;

import cn.dev33.satoken.stp.SaTokenInfo;
import cn.dev33.satoken.stp.StpUtil;
import com.alibaba.fastjson.JSON;
import com.lengqi.cloud.admin.common.exception.BizException;
import com.lengqi.cloud.admin.common.result.ResultCode;
import com.lengqi.cloud.admin.common.result.ResultVo;
import com.lengqi.cloud.admin.common.utils.DateAndStringUtil;
import com.lengqi.cloud.admin.feign.SysUserClient;
import com.lengqi.cloud.admin.vo.SysUserVO;
import com.lengqi.cloud.user.entity.SysUser;
import jdk.management.resource.ResourceContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;

@Service
@Slf4j
public class AuthService {

    @Resource
    private SysUserClient sysUserClient;

    public ResultVo<Object> doLogin(String key, String password){
        ResultVo<SysUserVO> resultVo = sysUserClient.selectUser(key, password);
        SysUserVO sysUserVO = resultVo.getData();
        log.info(sysUserVO.getUsername() + "登录成功");
        if (StringUtils.isEmpty(sysUserVO)){
            return ResultVo.failed(ResultCode.USER_NOT_EXIST);
        }
        StpUtil.setLoginId(sysUserVO.getId());
        SaTokenInfo tokenInfo = StpUtil.getTokenInfo();
        return ResultVo.success(tokenInfo);
    }
}
