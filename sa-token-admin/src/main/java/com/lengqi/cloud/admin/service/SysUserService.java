package com.lengqi.cloud.admin.service;

import com.lengqi.cloud.user.entity.SysUser;

public interface SysUserService {

    SysUser selectByUsername(String username, String password);

}

