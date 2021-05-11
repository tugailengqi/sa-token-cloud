package com.lengqi.cloud.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lengqi.cloud.admin.mapper.ScekillInfoMapper;
import com.lengqi.cloud.admin.service.ScekillInfoService;
import com.lengqi.cloud.common.redis.RedisLock;
import com.lengqi.cloud.common.result.ResultVo;
import com.lengqi.cloud.common.utils.RedisUtil;
import com.lengqi.cloud.user.entity.ScekillInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.Date;

@Service
@Slf4j
public class ScekillInfoServiceImpl extends ServiceImpl<ScekillInfoMapper, ScekillInfo> implements ScekillInfoService{

    /** 超时时间 */
    private static final int TIMEOUT = 10000;
    @Resource
    private RedisLock redisLock;

    @Resource
    private RedisUtil redisUtil;
    @Resource
    private ScekillInfoMapper scekillInfoMapper;


    public ResultVo<Object> seckillProduct(String username, String phone) {

        long time = System.currentTimeMillis() + TIMEOUT;

        Integer product = (Integer)redisUtil.get("product");



        //加锁
        String lockKey = username + phone + product;

        if (!redisLock.lock(lockKey,String.valueOf(time))){
            log.info("没抢到，换个姿势再试试～");
            return ResultVo.success("没抢到，换个姿势再试试");
        }
        if (product == 0){
            //库存不足
            redisLock.unLock(lockKey,String.valueOf(time));
            log.info("已抢完，请留意下次活动～");
            return ResultVo.success("已抢完，请留意下次活动～");
        }else {
            if (!StringUtils.isEmpty(redisUtil.get(phone))){
                redisLock.unLock(lockKey,String.valueOf(time));
                log.info("没人只能抢一台哦");
                return ResultVo.failed("没人只能抢一台哦");
            }
            try {
                ScekillInfo scekill = new ScekillInfo();
                scekill.setScekillPhone(phone);
                scekill.setScekillUsername(username);
                scekill.setCreateTime(new Date());
                scekillInfoMapper.insert(scekill);
                log.info("恭喜你，抢到了");
                log.info("用户：{},手机号：{}，抢到时间：{}",username,phone+"已抢到该商品",time);
                redisUtil.set("product",product-1);
                //没人只能抢一台
                redisUtil.set(phone,1);
                Thread.sleep(100);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        //解锁
        redisLock.unLock(lockKey,String.valueOf(time));
        return ResultVo.success("恭喜你，抢到了");
    }

}
