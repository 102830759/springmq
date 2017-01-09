package com.hdsx.mq.sevice.impl;

import com.hdsx.mq.sevice.CreateQueue;
import com.hdsx.mq.vo.Info;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.connection.SingleConnectionFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.jms.*;
import java.io.Serializable;

/**
 * Created by admin on 2017/1/6.
 */
@Service
public class CreateQueueImpl implements CreateQueue, MessageListener {

    @Resource
    @Qualifier("connectionFactory")
    private SingleConnectionFactory factory;

    public boolean create(String queueName) throws JMSException {

        Connection connection = factory.createConnection();
        connection.start();
        Session session = connection.createSession(false, Session.CLIENT_ACKNOWLEDGE);
        Destination queue = session.createQueue(queueName);
        createListen(queueName);
        return false;
    }

    public boolean createListen(String queueName) throws JMSException {
        Connection connection = factory.createConnection();
        connection.start();
        Session session = connection.createSession(true, Session.AUTO_ACKNOWLEDGE);
        Destination destination = session.createQueue(queueName);
        //消息消费者
        MessageConsumer consumer = session.createConsumer(destination);
        consumer.setMessageListener(this);
        return true;
    }

    /*public void onMessage(Message message) {
        try {
            TextMessage textMsg = (TextMessage) message;
            Destination jmsDestination = message.getJMSDestination();
            String s = jmsDestination.toString();
            System.out.println(s + "消息队列收到消息");
            System.out.println("消息内容是：" + textMsg.getText());
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }*/
    public void onMessage(Message message) {
        try {
            Serializable object = ((ObjectMessage) message).getObject();
            Info object1 = (Info) object;
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
