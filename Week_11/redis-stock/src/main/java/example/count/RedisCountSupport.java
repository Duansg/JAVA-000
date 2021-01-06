package example.count;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

/**
 * RedisCountSupport
 *
 * @author duansg
 * @version 1.0
 * @date 2021/1/6 下午10:56
 */
@Component
public class RedisCountSupport {

    private static RedisTemplate redisTemplate;

    @Autowired
    public RedisCountSupport(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }


    /**
     * @test see org.example.TestCount
     */
    public static void setStock(String key, int stock) {
        redisTemplate.opsForValue().set(key,stock);
    }

    public static boolean deductStock(String key, int stockValue) {
        if (redisTemplate.opsForValue().decrement(key, stockValue) >= 0){
            return true;
        }
        return false;
    }
}
