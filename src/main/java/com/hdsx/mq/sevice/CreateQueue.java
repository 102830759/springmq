package com.hdsx.mq.sevice;

import javax.jms.JMSException;
import javax.jms.MessageListener;

/**
 * Created by admin on 2017/1/6.
 */
public interface CreateQueue {

    /**
     * 创建队列
     * @param queueName 队列名
     * @param listener 队列对应的监听
     * @return
     * @throws JMSException
     */
    boolean create(String queueName, MessageListener listener) throws JMSException;
}
