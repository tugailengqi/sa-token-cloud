package com.lengqi.cloud.admin.service;

import com.lengqi.user.entity.SysUserRole;

public interface SysUserRoleService {


    int deleteByPrimaryKey(Integer id);

    int insert(SysUserRole record);

    int insertSelective(SysUserRole record);

    SysUserRole selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysUserRole record);

    int updateByPrimaryKey(SysUserRole record);

}

