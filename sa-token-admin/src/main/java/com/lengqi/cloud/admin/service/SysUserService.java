package com.lengqi.cloud.admin.service;

import com.lengqi.user.entity.SysUser;

public interface SysUserService {


    int deleteByPrimaryKey(Long id);

    int insert(SysUser record);

    int insertSelective(SysUser record);

    SysUser selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysUser record);

    int updateByPrimaryKey(SysUser record);

}

