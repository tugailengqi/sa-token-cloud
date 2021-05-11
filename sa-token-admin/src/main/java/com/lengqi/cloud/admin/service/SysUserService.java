package com.lengqi.cloud.admin.service;

import com.lengqi.cloud.common.exception.BizException;
import com.lengqi.cloud.user.entity.SysUser;

public interface SysUserService {

    SysUser selectByUsername(String username, String password) throws BizException;

    SysUser selectUserById(Long id);
}

