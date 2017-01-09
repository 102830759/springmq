package com.hdsx.mq.sevice;

import javax.jms.JMSException;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;


/**
 * Created by admin on 2017/1/6.
 */
public interface SendMessage<T> {

    /**
     * 字符串
     * @param name
     * @param text
     * @return
     * @throws JMSException
     */
    boolean sendMessage(String name,String text) throws JMSException;

    /**
     * 对象
     * @param name
     * @param t
     * @return
     * @throws JMSException
     */
    boolean sendMessageObject(String name, T t) throws JMSException;

    /**
     * 字节流
     * @param name
     * @param stream
     * @return
     * @throws JMSException
     * @throws IOException
     */
    boolean sendMessageStream(String name, InputStream stream) throws JMSException, IOException;

    /**
     *
     * @param name
     * @param bytes
     * @return
     * @throws JMSException
     * @throws IOException
     */
    boolean sendMessageBytes(String name, byte[] bytes) throws JMSException, IOException;

}
