package com.hdsx.mq.sevice.impl;

import com.hdsx.mq.sevice.SendMessage;
import com.hdsx.mq.vo.Info;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.connection.SingleConnectionFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.jms.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.Map;

/**
 * Created by admin on 2017/1/6.
 */
@Service
public class SendMessageImpl implements SendMessage {

    @Resource
    @Qualifier("connectionFactory")
    private SingleConnectionFactory factory;

    public boolean sendMessage(String name, String text) throws JMSException {
        if ("".equals(name) || name == null)
            return false;
        Connection connection = factory.createConnection();
        connection.start();
        Session session = connection.createSession(false, Session.CLIENT_ACKNOWLEDGE);
        Destination queue = session.createQueue(name);
        MessageProducer producer = session.createProducer(queue);
        producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
        TextMessage message = session.createTextMessage(text);
        producer.send(message);
        return true;
    }


    public boolean sendMessageObject(String name, Object o) throws JMSException {
        if ("".equals(name) || name == null)
            return false;
        Connection connection = factory.createConnection();
        connection.start();
        Session session = connection.createSession(false, Session.CLIENT_ACKNOWLEDGE);
        Destination queue = session.createQueue(name);
        MessageProducer producer = session.createProducer(queue);
        producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
        ObjectMessage objectMessage = session.createObjectMessage();

        objectMessage.setObject((Serializable) o);
        producer.send(objectMessage);
        return true;
    }


    public boolean sendMessageStream(String name, InputStream stream) throws JMSException, IOException {
        if ("".equals(name) || name == null)
            return false;
        Connection connection = factory.createConnection();
        connection.start();
        Session session = connection.createSession(false, Session.CLIENT_ACKNOWLEDGE);
        Destination queue = session.createQueue(name);
        MessageProducer producer = session.createProducer(queue);
        producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
        StreamMessage streamMessage = session.createStreamMessage();
        byte b[] = new byte[1024];
        int len = 0;
        int temp = 0;          //所有读取的内容都使用temp接收
        while ((temp = stream.read()) != -1) {    //当没有读取完时，继续读取
            b[len] = (byte) temp;
            len++;
        }
        streamMessage.setJMSCorrelationIDAsBytes(b);
        producer.send(streamMessage);
        return true;
    }

    public boolean sendMessageBytes(String name, byte[] bytes) throws JMSException, IOException {
        if ("".equals(name) || name == null)
            return false;
        Connection connection = factory.createConnection();
        connection.start();
        Session session = connection.createSession(false, Session.CLIENT_ACKNOWLEDGE);
        Destination queue = session.createQueue(name);
        MessageProducer producer = session.createProducer(queue);
        producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
        BytesMessage bytesMessage = session.createBytesMessage();
        bytesMessage.setJMSCorrelationIDAsBytes(bytes);
        producer.send(bytesMessage);
        return true;
    }

    public boolean sendMessageMap(String name, Map map) throws JMSException {
        if ("".equals(name) || name == null)
            return false;
        Connection connection = factory.createConnection();
        connection.start();
        Session session = connection.createSession(false, Session.CLIENT_ACKNOWLEDGE);
        Destination queue = session.createQueue(name);
        MessageProducer producer = session.createProducer(queue);
        producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
        MapMessage mapMessage = session.createMapMessage();
        mapMessage.setObject("", "");
        producer.send(mapMessage);
        return true;
    }
}
