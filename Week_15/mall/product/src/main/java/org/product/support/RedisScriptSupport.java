package org.product.support;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.scripting.support.ResourceScriptSource;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * RedisScriptSupport
 *
 * @author duansg
 * @version 1.0
 * @date 2021/1/27 下午4:00
 */
@Component
public class RedisScriptSupport {

    @Autowired
    private RedisTemplate redisTemplate;

    private final DefaultRedisScript<String> script = new DefaultRedisScript<>();

    @PostConstruct
    private void init() {
        script.setResultType(String.class);
        script.setScriptSource(new ResourceScriptSource(new ClassPathResource("luascript/deduct_stock.lua")));
    }

    public Object execute(List<String> keyList, List<String> argvList) {
        return redisTemplate.execute(script, keyList, argvList);
    }
    public Object execute(List<String> keyList, Object... args) {
        return redisTemplate.execute(script, keyList, args);
    }
}
