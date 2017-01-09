package com.hdsx.mq.sevice.impl;


import com.hdsx.mq.sevice.Product;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.jms.*;
import java.io.Serializable;
import java.util.Enumeration;

/**
 * 消息生产者
 * Created by admin on 2016/9/28.
 */

@Service
public class ProductImpl implements Product {

    @Resource
    private JmsTemplate jmsTemplate;

    @Resource
    @Qualifier("queueDestination")
    private ActiveMQQueue destination;

    public void sendMessage(Destination destination,final String message) {
        jmsTemplate.send(destination, new MessageCreator() {
            public Message createMessage(Session session) throws JMSException {
                return session.createTextMessage(message);
            }
        });
    }

    public void sendMessage(String message) {
        this.sendMessage(destination,message);
    }

}