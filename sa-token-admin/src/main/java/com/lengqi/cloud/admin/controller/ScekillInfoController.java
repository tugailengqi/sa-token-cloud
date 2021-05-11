package com.lengqi.cloud.admin.controller;

import com.lengqi.cloud.admin.service.ScekillInfoService;
import com.lengqi.cloud.common.result.ResultVo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/scekill")
public class ScekillInfoController {

    @Resource
    private ScekillInfoService scekillInfoService;

    @GetMapping("/test")
    public String test(){
        return "cheng";
    }

    @GetMapping("/seckillProduct")
    public ResultVo<Object> seckillProduct(@RequestParam String username, @RequestParam String phone){
        return scekillInfoService.seckillProduct(username, phone);
    }
}
