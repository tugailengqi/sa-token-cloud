package com.lengqi.cloud.admin;

import cn.hutool.crypto.SecureUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MYTest {
    @Resource
    private PasswordEncoder passwordEncoder;
    @org.junit.Test
    public void passEncode(){
        String password = "123456";
        String encode = passwordEncoder.encode("123456");
        System.out.println(encode);
        System.out.println(passwordEncoder.matches("123456",encode));

        String sha256 = SecureUtil.sha256(password);
        System.out.println(sha256);
    }
}
