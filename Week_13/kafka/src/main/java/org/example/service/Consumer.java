package org.example.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;


/**
 * Consumer
 *
 * @author duansg
 * @version 1.0
 * @date 2021/1/13 下午9:01
 */
@Component
public class Consumer {

    @KafkaListener(topics = "test-topic",id = "consumer-id")
    public void topic_test(String msg) {
        System.out.println(msg);
    }
}
