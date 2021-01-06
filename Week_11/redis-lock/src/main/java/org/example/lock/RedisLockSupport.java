package org.example.lock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.concurrent.TimeUnit;

/**
 * RedisLockSupport
 *
 * @author duansg
 * @version 1.0
 * @date 2021/1/6 下午10:40
 */
@Component
public class RedisLockSupport {

    private static RedisTemplate redisTemplate;

    @Autowired
    public RedisLockSupport(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    /**
     * @test see org.example.TestLock
     */
    public static Boolean lock(String key, String version ,int seconds) {
        try {
            return redisTemplate.opsForValue().setIfAbsent(key, version, seconds, TimeUnit.SECONDS);
        }catch (Exception e){
            redisTemplate.expire(key, seconds, TimeUnit.SECONDS);
        }
        return false;
    }

    /**
     * @test see org.example.TestLock
     */
    public static boolean unLock(String key, String version) {
        String v = (String) redisTemplate.opsForValue().get(key);
        if (!StringUtils.isEmpty(v)&&v.equals(version)){
            return redisTemplate.delete(key);
        }
        return false;
    }
}
