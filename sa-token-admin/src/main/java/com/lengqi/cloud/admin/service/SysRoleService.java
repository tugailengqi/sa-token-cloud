package com.lengqi.cloud.admin.service;

import com.lengqi.user.entity.SysRole;

public interface SysRoleService {


    int deleteByPrimaryKey(Integer id);

    int insert(SysRole record);

    int insertSelective(SysRole record);

    SysRole selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysRole record);

    int updateByPrimaryKey(SysRole record);

}

