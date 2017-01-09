package com.hdsx.mq.sevice;


import javax.jms.Destination;
import javax.jms.ObjectMessage;

public interface Product {

    public void sendMessage(Destination destination, final String message);
    void sendMessage(String message);
}