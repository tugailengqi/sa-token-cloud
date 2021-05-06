package com.lengqi.cloud.admin.service;

import com.lengqi.user.entity.SysRolePermission;

public interface SysRolePermissionService {


    int deleteByPrimaryKey(Integer id);

    int insert(SysRolePermission record);

    int insertSelective(SysRolePermission record);

    SysRolePermission selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysRolePermission record);

    int updateByPrimaryKey(SysRolePermission record);

}

