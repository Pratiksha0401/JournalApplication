package com.demo.journalApp.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
public class RedisServiceTest {

    @Autowired
    RedisTemplate redisTemplate;

    @Test
    public void getValueTest() throws JsonProcessingException {
        redisTemplate.opsForValue().set("email","gmail@email.com");
        Object salary = redisTemplate.opsForValue().get("name");
        int a = 1;
    }
}
