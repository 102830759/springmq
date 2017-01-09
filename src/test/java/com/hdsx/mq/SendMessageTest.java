package com.hdsx.mq;

import com.hdsx.mq.sevice.SendMessage;
import com.hdsx.mq.vo.Info;
import org.junit.Test;

import javax.annotation.Resource;
import javax.jms.JMSException;

/**
 * Created by admin on 2017/1/9.
 */
public class SendMessageTest extends  SpringJunitTest{

    @Resource
    private SendMessage sendMessage;

    @Test
    public void testObject(){
        Info info = new Info();
        info.setSender("领导");
        info.setRecipient("下属");
        try {
            sendMessage.sendMessageObject("zhangs", info);
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
