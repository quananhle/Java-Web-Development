package com.udacity.jwdnd.cl.review.model;

public class ChatMessage {
    private String messageID;
    private String username;
    private String messages;

    public String getMessageID() {
        return messageID;
    }

    public void setMessageID(String messageID) {
        this.messageID = messageID;
    }

    public String getUsername() {
        return username;
    }

    public String getMessages() {
        return messages;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setMessages(String messages) {
        this.messages = messages;
    }
}
