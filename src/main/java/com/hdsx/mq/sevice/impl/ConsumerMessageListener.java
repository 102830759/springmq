package com.hdsx.mq.sevice.impl;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * Created by admin on 2017/1/4.
 */
public class ConsumerMessageListener implements MessageListener {

    public void onMessage(Message message) {
        TextMessage textMsg = (TextMessage) message;
        try {
            System.out.println("接收者收到消息：" + textMsg.getText());
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
