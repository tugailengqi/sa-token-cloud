package com.lengqi.cloud.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lengqi.cloud.common.result.ResultVo;
import com.lengqi.cloud.user.entity.ScekillInfo;

public interface ScekillInfoService extends IService<ScekillInfo>{
    ResultVo<Object> seckillProduct(String username, String phone);

}
