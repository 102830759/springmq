package com.hdsx.mq.sevice;

/**
 * 监听器
 * Created by admin on 2016/10/10.
 */
public interface IMessageListener {

    boolean onMessage(Object message);

    public static class Adapter implements IMessageListener {

        public boolean onMessage(Object message) {
            return false;
        }
    }
}
