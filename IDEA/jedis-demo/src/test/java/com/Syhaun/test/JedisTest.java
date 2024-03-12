package com.Syhaun.test;

import com.Syhaun.jedis.util.JedisConnectionFactory;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import redis.clients.jedis.Jedis;

import java.util.Map;

public class JedisTest {
    private Jedis jedis;
    @BeforeEach
    void setUp() {
        //1.建立连接
       // jedis = new Jedis("192.168.199.128",6379);
        jedis = JedisConnectionFactory.getJedis();
        //2.设置密码
        //jedis.auth("Syhaun");
        //3.选择库
        jedis.select(0);
    }
    @Test
    void testHash() {
        //插入hash数据
        jedis.hset("user:1","name","J=是的哈哈的" );
        jedis.hset("user:1","age","21");
        //获取数据
        Map<String, String> stringStringMap = jedis.hgetAll("user:1");
        System.out.println(stringStringMap);
    }

    @Test
    void testString() {
        //存入数据
        String result = jedis.set("name", "张超");
        System.out.println(result);
        //获取数据
        String name = jedis.get("name");
        System.out.println(name);
    }
        //4.释放资源
    @AfterEach
    void tearDown() {
        if(jedis != null)
            jedis.close();
    }
}
