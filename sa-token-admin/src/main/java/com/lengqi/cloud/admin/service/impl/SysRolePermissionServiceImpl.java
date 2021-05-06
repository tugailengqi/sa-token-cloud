package com.lengqi.cloud.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lengqi.cloud.admin.mapper.SysPermissionsMapper;
import com.lengqi.user.entity.SysPermissions;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.lengqi.user.entity.SysRolePermission;
import com.lengqi.cloud.admin.mapper.SysRolePermissionMapper;
import com.lengqi.cloud.admin.service.SysRolePermissionService;

@Service
public class SysRolePermissionServiceImpl extends ServiceImpl<SysRolePermissionMapper, SysRolePermission> implements SysRolePermissionService {

    @Resource
    private SysRolePermissionMapper sysRolePermissionMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return sysRolePermissionMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(SysRolePermission record) {
        return sysRolePermissionMapper.insert(record);
    }

    @Override
    public int insertSelective(SysRolePermission record) {
        return sysRolePermissionMapper.insertSelective(record);
    }

    @Override
    public SysRolePermission selectByPrimaryKey(Integer id) {
        return sysRolePermissionMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(SysRolePermission record) {
        return sysRolePermissionMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(SysRolePermission record) {
        return sysRolePermissionMapper.updateByPrimaryKey(record);
    }

}

