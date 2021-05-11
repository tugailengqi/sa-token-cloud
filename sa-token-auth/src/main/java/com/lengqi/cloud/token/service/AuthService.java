package com.lengqi.cloud.token.service;

import cn.dev33.satoken.stp.SaTokenInfo;
import cn.dev33.satoken.stp.StpUtil;
import com.lengqi.cloud.common.result.ResultCode;
import com.lengqi.cloud.common.result.ResultVo;
import com.lengqi.cloud.admin.feign.SysUserClient;
import com.lengqi.cloud.admin.vo.SysUserVO;
import com.lengqi.cloud.common.utils.StpUserUtil;
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
            if (StringUtils.isEmpty(sysUserVO)){
                return ResultVo.failed(ResultCode.USERNAME_OR_PASSWORD_ERROR);
            }
            log.info(sysUserVO.getUsername() + "登录成功");
            if (StringUtils.isEmpty(sysUserVO)){
                return ResultVo.failed(ResultCode.USER_NOT_EXIST);
            }
            StpUserUtil.setLoginId(sysUserVO.getId());
            SaTokenInfo tokenInfo = StpUserUtil.getTokenInfo();
            return ResultVo.success(tokenInfo);
    }

    public ResultVo<Object> logout(){
        String loginId = (String)StpUserUtil.getLoginId();
        ResultVo<SysUserVO> resultVo = sysUserClient.findUserById(Long.parseLong(loginId));
        if (StringUtils.isEmpty(resultVo)){
            return ResultVo.failed("登出失败");
        }
        log.info(resultVo.getData().getUsername() +" : 已退出登录。。。。");
        StpUserUtil.logout();
        return ResultVo.success("登出成功");
    }
}
