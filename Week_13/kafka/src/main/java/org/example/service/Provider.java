package org.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

/**
 * Provider
 *
 * @author duansg
 * @version 1.0
 * @date 2021/1/13 下午9:01
 */
@Component
public class Provider {

    @Autowired
    private  KafkaTemplate kafkaTemplate;

    public void produce() {
        //发送消息
        ListenableFuture<SendResult<String, String>> future = kafkaTemplate.send("test-topic", "test message");
        future.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {
            @Override
            public void onFailure(Throwable throwable) {
                System.out.println(" - 生产者 发送消息失败：" + throwable.getMessage());
            }
            @Override
            public void onSuccess(SendResult<String, String> stringObjectSendResult) {
                System.out.println(" - 生产者 发送消息成功：" + stringObjectSendResult.toString());
            }
        });
    }

}
