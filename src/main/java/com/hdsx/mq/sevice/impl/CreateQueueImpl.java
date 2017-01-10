package com.hdsx.mq.sevice.impl;

import com.hdsx.mq.sevice.CreateQueue;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.connection.SingleConnectionFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.jms.*;

/**
 * Created by admin on 2017/1/6.
 */
@Service
public class CreateQueueImpl implements CreateQueue {

    @Resource
    @Qualifier("connectionFactory")
    private SingleConnectionFactory factory;

    public boolean create(String queueName, MessageListener listener) throws JMSException {
        Connection connection = factory.createConnection();
        connection.start();
        Session session = connection.createSession(false, Session.CLIENT_ACKNOWLEDGE);
        session.createQueue(queueName);
        MessageConsumer consumer = this.createConsumer(queueName);
        consumer.setMessageListener(listener);
        return true;
    }

    public MessageConsumer createConsumer(String queueName) throws JMSException {
        Connection connection = factory.createConnection();
        connection.start();
        Session session = connection.createSession(true, Session.AUTO_ACKNOWLEDGE);
        Destination destination = session.createQueue(queueName);
        //消息消费者
        MessageConsumer consumer = session.createConsumer(destination);
        return consumer;
    }

}
