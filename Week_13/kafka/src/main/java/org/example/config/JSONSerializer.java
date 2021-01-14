package org.example.config;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.kafka.common.serialization.Serializer;

import java.util.Map;
/**
 * JSONSerializer
 *
 * @author duansg
 * @version 1.0
 * @date 2021/1/13 下午11:20
 */
public class JSONSerializer implements Serializer<JSONObject>{

    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {

    }

    @Override
    public byte[] serialize(String s, JSONObject jsonObject) {
        return JSON.toJSONBytes(jsonObject);
    }

    @Override
    public void close() {

    }
}