package com.hdsx.mq;

import com.hdsx.mq.sevice.CreateQueue;
import org.junit.Test;

import javax.annotation.Resource;
import javax.jms.JMSException;

/**
 * Created by admin on 2017/1/6.
 */
public class CreateQueueTest extends SpringJunitTest{
    @Resource
    private CreateQueue createQueue;

    @Test
    public void tes(){
        try {
            createQueue.create("lisi");
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
