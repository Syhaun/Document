package com.syhaun.redisdemo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.syhaun.redisdemo.redis.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.Map;

@SpringBootTest
class RedisStringTests {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    //JSON工具
    private static final ObjectMapper mapper = new ObjectMapper();
    @Test
    void testSavaUser() throws JsonProcessingException {
        //创建对象
        User user = new User("张超",21);
//        手动序列化
        String json = mapper.writeValueAsString(user);
//        写入数据
        stringRedisTemplate.opsForValue().set("user:200",json);
//        获取数据
        String jsonUser = stringRedisTemplate.opsForValue().get("user:200");
//        反序列化
        User user1 = mapper.readValue(jsonUser, User.class);
        System.out.println(user1);
    }
    @Test
    void testHash() {
        stringRedisTemplate.opsForHash().put("User:400","name","张超");
        stringRedisTemplate.opsForHash().put("User:400","age","21");

        Map<Object, Object> entries = stringRedisTemplate.opsForHash().entries("user:400");
        System.out.println("entries = " + entries);

    }

}
