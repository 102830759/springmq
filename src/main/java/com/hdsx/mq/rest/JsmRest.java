package com.hdsx.mq.rest;

import com.hdsx.mq.sevice.CreateQueue;
import com.hdsx.mq.sevice.Product;
import com.hdsx.mq.sevice.SendMessage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.jms.JMSException;

/**
 * Created by admin on 2017/1/6.
 */
@Api("rest服务")
@RestController
@RequestMapping("jms")
public class JsmRest {

    @Resource
    private Product product;

    @Resource
    private SendMessage sendMessage;
    @Resource
    private CreateQueue createQueue;

    @ApiOperation("发送消息")
    @RequestMapping(value = "test", method = RequestMethod.GET)
    public boolean sendMessage(@RequestParam(value = "json") String json) {
        boolean flag = false;
        try {
            product.sendMessage(json);
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    @ApiOperation("创建队列")
    @RequestMapping(value = "create", method = RequestMethod.GET)
    public boolean createQueue(@RequestParam(value = "name") String name) {
        boolean flag = false;
        try {
            createQueue.create(name);
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    @ApiOperation("指定接收者发送消息")
    @RequestMapping(value = "sendMessage", method = RequestMethod.GET)
    public boolean sendToUser(@ApiParam(required = true, defaultValue = "queue") @RequestParam(value = "name", defaultValue = "queue", required = true) String name,
                              @ApiParam(required = true, defaultValue = "hello") @RequestParam(value = "text", defaultValue = "hello", required = true) String text
    ) {
        boolean flag = false;
        try {
            sendMessage.sendMessage(name, text);
            flag = true;
        } catch (JMSException e) {
            e.printStackTrace();
        }
        return flag;
    }
}
