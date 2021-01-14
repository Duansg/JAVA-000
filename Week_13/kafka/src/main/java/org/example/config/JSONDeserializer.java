package org.example.config;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.kafka.common.serialization.Deserializer;

import java.util.Map;

/**
 * JSONDeserializer
 *
 * @author duansg
 * @version 1.0
 * @date 2021/1/13 下午11:20
 */
public class JSONDeserializer implements Deserializer<JSONObject> {
    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {

    }

    @Override
    public JSONObject deserialize(String s, byte[] bytes) {
        return JSON.parseObject(bytes,JSONObject.class);
    }

    @Override
    public void close() {

    }
}
