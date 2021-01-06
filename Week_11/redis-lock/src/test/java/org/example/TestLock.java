package org.example;

import org.example.lock.RedisLockSupport;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Test_1
 * @author duansg
 * @version 1.0
 * @date 2021/1/6 下午10:24
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ApplicationServer.class)
public class TestLock{

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void test(){

        Boolean result = RedisLockSupport.lock("duansg", "1.0", 30);
        System.out.println("尝试加锁,结果:" + result);
        Boolean result1 = RedisLockSupport.lock("duansg", "1.0", 30);
        System.out.println("尝试加锁,结果:" + result1);
        Boolean unLock1 = RedisLockSupport.unLock("duansg", "2.0");
        System.out.println("尝试解锁,结果:" + unLock1);
        Boolean unLock2 = RedisLockSupport.unLock("duansg", "1.0");
        System.out.println("尝试解锁,结果:" + unLock2);


    }
}
