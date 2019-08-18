package io.ivanclare.chat;

import com.alibaba.fastjson.JSON;

/**
 * WebSocket message model
 */
public class Message {
	
	private String type;
	private String sender;
    private String content;
    private int numOnline; //number of online users
    
    public static final String JOIN  = "JOIN";
    public static final String CHAT  = "CHAT";
    public static final String LEAVE = "LEAVE";

    public Message() {
    }
    
    public Message(String type, String sender, String content, int numOnline) {
    	this.type = type;
    	this.sender = sender;
    	this.content = content;
    	this.numOnline = numOnline;
    }
    
    public Message(String text) {
        this.content = text;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
	
    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }
    public static String jsonStr(String type, String sender, String content, int onlineTotal) {
    	return JSON.toJSONString(new Message(type, sender, content, onlineTotal));
    }
}
