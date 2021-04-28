package xyz.solidspoon.mall.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import xyz.solidspoon.mall.service.RedisService;

import java.util.concurrent.TimeUnit;

/**
 * @author solidSpoon
 * @date 2021/4/27 20:32
 */
@Service
public class RedisServiceImpl implements RedisService {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public void set(String key, String value) {
        stringRedisTemplate.opsForValue().set(key, value);
    }

    @Override
    public String get(String key) {
        return stringRedisTemplate.opsForValue().get(key);
    }

    @Override
    public boolean expire(String key, long expire) {
        return stringRedisTemplate.expire(key, expire, TimeUnit.SECONDS);
    }

    @Override
    public void remove(String key) {
        stringRedisTemplate.delete(key);
    }

    @Override
    public Long increment(String key, long delta) {
        return stringRedisTemplate.opsForValue().increment(key, delta);
    }
}
