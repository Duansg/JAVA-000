package org.example.base;

import lombok.SneakyThrows;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * CustomMq
 *
 * @author duansg
 * @version 1.0
 * @date 2021/1/20 下午10:43
 */
public final class CustomMq {

    private String topic;

    private int capacity;

    private LinkedBlockingQueue<CustomMqMessage> queue;

    public CustomMq(String topic,int capacity){
        this.topic = topic;
        this.capacity = capacity;
        this.queue = new LinkedBlockingQueue(capacity);
    }

    public boolean send(CustomMqMessage message){
        return queue.offer(message);
    }

    public CustomMqMessage poll(){
        return queue.poll();
    }

    @SneakyThrows
    public CustomMqMessage poll(long timeout) {
        return queue.poll(timeout, TimeUnit.MILLISECONDS);
    }

}