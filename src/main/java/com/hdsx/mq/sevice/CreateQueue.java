package com.hdsx.mq.sevice;

import javax.jms.JMSException;

/**
 * Created by admin on 2017/1/6.
 */
public interface CreateQueue {
    boolean create(String queueName) throws JMSException;
    boolean createListen(String queueName) throws JMSException;
}
