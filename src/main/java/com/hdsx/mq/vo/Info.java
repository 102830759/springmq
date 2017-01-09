package com.hdsx.mq.vo;

import java.io.Serializable;
import java.util.Map;

/**
 * Created by admin on 2017/1/9.
 */
public class Info implements Serializable{

    private static final long serialVersionUID = 791968161399989164L;
    /**
     * 收件人
     */
    private String recipient;
    /**
     * 发件人
     */
    private String sender;
    /**
     * 内容
     */
    private Map<String,Object> content;

    public String getRecipient() {
        return this.recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public String getSender() {
        return this.sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public Map<String, Object> getContent() {
        return this.content;
    }

    public void setContent(Map<String, Object> content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Info{" +
                "recipient='" + recipient + '\'' +
                ", sender='" + sender + '\'' +
                ", content=" + content +
                '}';
    }
}
