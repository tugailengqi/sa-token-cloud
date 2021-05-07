package com.lengqi.cloud.admin.service.impl;

import cn.dev33.satoken.stp.StpUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lengqi.cloud.admin.mapper.SysUserMapper;
import com.lengqi.cloud.admin.service.SysUserService;
import com.lengqi.cloud.admin.common.exception.BizException;
import com.lengqi.cloud.admin.common.result.ResultCode;
import com.lengqi.cloud.user.entity.SysUser;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

import org.springframework.util.StringUtils;

@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {

    @Resource
    private PasswordEncoder passwordEncoder;

    @Override
    public SysUser selectByUsername(String username,String password) {
        SysUser sysUser = getOne(new QueryWrapper<SysUser>().eq("username", username));
        if (StringUtils.isEmpty(sysUser)){
            throw new BizException(ResultCode.USER_NOT_EXIST);
        }
        boolean matches = passwordEncoder.matches(password, sysUser.getPassword());
        if (!matches){
            throw new BizException(ResultCode.USERNAME_OR_PASSWORD_ERROR);
        }
        return sysUser;
    }

    @Override
    public SysUser selectUserById(Long id) {
        SysUser sysUser = getById(id);
        if (StringUtils.isEmpty(sysUser)){
            throw new BizException("查询用户为空");
        }
        return sysUser;
    }

}

