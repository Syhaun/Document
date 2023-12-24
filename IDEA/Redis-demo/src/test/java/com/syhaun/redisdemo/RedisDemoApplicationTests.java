package com.syhaun.redisdemo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
class RedisDemoApplicationTests {

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    void contextLoads() {
    }

    @Test
    void testString() {

        //写入一个stirng数据
        redisTemplate.opsForValue().set("name", "张超");
        //获取string数据
        Object name = redisTemplate.opsForValue().get("name");
        System.out.println(name);
    }
}
