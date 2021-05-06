package com.lengqi.cloud.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.lengqi.user.entity.SysPermissions;
import com.lengqi.cloud.admin.mapper.SysPermissionsMapper;
import com.lengqi.cloud.admin.service.SysPermissionsService;

@Service
public class SysPermissionsServiceImpl extends ServiceImpl<SysPermissionsMapper,SysPermissions> implements SysPermissionsService {

    @Resource
    private SysPermissionsMapper sysPermissionsMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return sysPermissionsMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(SysPermissions record) {
        return sysPermissionsMapper.insert(record);
    }

    @Override
    public int insertSelective(SysPermissions record) {
        return sysPermissionsMapper.insertSelective(record);
    }

    @Override
    public SysPermissions selectByPrimaryKey(Integer id) {
        return sysPermissionsMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(SysPermissions record) {
        return sysPermissionsMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(SysPermissions record) {
        return sysPermissionsMapper.updateByPrimaryKey(record);
    }

}

