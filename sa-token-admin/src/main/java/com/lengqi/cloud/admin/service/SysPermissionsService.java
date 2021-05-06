package com.lengqi.cloud.admin.service;

import com.lengqi.user.entity.SysPermissions;

public interface SysPermissionsService {


    int deleteByPrimaryKey(Integer id);

    int insert(SysPermissions record);

    int insertSelective(SysPermissions record);

    SysPermissions selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysPermissions record);

    int updateByPrimaryKey(SysPermissions record);

}

