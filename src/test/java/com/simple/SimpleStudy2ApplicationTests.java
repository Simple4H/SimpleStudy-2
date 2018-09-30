package com.simple;

import com.simple.redis.User;
import lombok.extern.slf4j.Slf4j;
import org.checkerframework.checker.units.qual.A;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class SimpleStudy2ApplicationTests {

    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    @Test
    public void contextLoads() {
        for (int i = 1; i <= 100; i++) {
            if (i % 3 == 0 && i % 7 == 0) {
                log.error("i={}", i);
            }
        }
    }

    @Test
    public void redisTest() {
        User user = new User("simple","password");
        Boolean flag;
        flag = redisTemplate.opsForValue().setIfAbsent("user",user);
        if (flag){
            log.warn("User:{}",redisTemplate.opsForValue().get("user"));
        }
        else {
            log.error("the key is exist");
        }
    }
}
