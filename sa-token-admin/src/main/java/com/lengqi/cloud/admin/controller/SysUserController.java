package com.lengqi.cloud.admin.controller;

import com.lengqi.cloud.admin.common.result.ResultCode;
import com.lengqi.cloud.admin.common.result.ResultVo;
import com.lengqi.cloud.admin.service.SysUserService;
import com.lengqi.cloud.admin.common.exception.BizException;
import com.lengqi.cloud.admin.common.utils.DateAndStringUtil;
import com.lengqi.cloud.user.entity.SysUser;
import com.lengqi.cloud.admin.vo.SysUserVO;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/sys_user")
public class SysUserController {

    @Resource
    private SysUserService sysUserService;

    //注册用户
    @PostMapping("/register")
    public ResultVo register(SysUser sysUser){
        return null;
    }

    //查询用户列表



    //查询用户
    @PostMapping("/selectUser")
    public ResultVo<SysUserVO> selectUser(@RequestParam String username, @RequestParam String password){
        try {
            if (DateAndStringUtil.isOneNull(username,password)){
                throw new BizException("用户名或密码不能为空");
            }
            SysUserVO sysUserVO = new SysUserVO();
            SysUser sysUser = sysUserService.selectByUsername(username, password);
            BeanCopier.create(sysUser.getClass(),sysUserVO.getClass(),false).copy(sysUser,
                    sysUserVO,
                    null);
            return ResultVo.success(sysUserVO);
        } catch (BizException e) {
            return ResultVo.failed(ResultCode.USERNAME_OR_PASSWORD_ERROR);
        }
    }

    @GetMapping("/findUserById")
    public ResultVo<SysUserVO> findUserById(@RequestParam Long id){
           SysUser sysUser = sysUserService.selectUserById(id);
        SysUserVO sysUserVO = new SysUserVO();
        BeanCopier.create(sysUser.getClass(),sysUserVO.getClass(),false).copy(sysUser,sysUserVO,null);
        return ResultVo.success(sysUserVO);
    }



    //删除用户


    //更新用户信息

}
