package com.lengqi.cloud.admin.feign;

import com.lengqi.cloud.admin.common.result.ResultVo;
import com.lengqi.cloud.admin.vo.SysUserVO;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("sa-token-admin")
public interface SysUserClient {
    @PostMapping("/sys_user/selectUser")
    ResultVo<SysUserVO> selectUser(@RequestParam String username, @RequestParam String password);

    @GetMapping("/sys_user/findUserById")
    ResultVo<SysUserVO> findUserById(@RequestParam Long id);
}
