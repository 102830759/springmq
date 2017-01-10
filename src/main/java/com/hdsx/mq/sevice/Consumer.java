package com.hdsx.mq.sevice;


import javax.jms.Message;
import javax.jms.MessageListener;

/**
 * Created by admin on 2016/10/10.
 */
public interface Consumer extends MessageListener {
    public void onMessage(Message message);
}
