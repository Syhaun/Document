package com.syhaun.redisdemo;

import com.syhaun.redisdemo.redis.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.graphql.tester.AutoConfigureGraphQlTester;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
class RedisDemoApplicationTests {

    @Autowired private RedisTemplate<String,Object> redisTemplate;

    @Test
    void testString() {
        //插入一条string类型的数据
        redisTemplate.opsForValue().set("name","上帝");
//        读取一条string类型的数据
        Object name = redisTemplate.opsForValue().get("name");
        System.out.println(name);
    }
    @Test
    void testSavaUser() {
//        写入数据
        redisTemplate.opsForValue().set("user:100",new User("张超",21));
//        获取数据
        Object o =(User)redisTemplate.opsForValue().get("user:100");
        System.out.println(o);
    }

}
