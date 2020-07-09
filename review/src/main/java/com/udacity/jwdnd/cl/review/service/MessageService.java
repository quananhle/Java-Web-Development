package com.udacity.jwdnd.cl.review.service;

import com.udacity.jwdnd.cl.review.mapper.MessagesMapper;
import com.udacity.jwdnd.cl.review.model.ChatForm;
import com.udacity.jwdnd.cl.review.model.ChatMessage;
import org.springframework.stereotype.Service;
import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class MessageService {
    private MessagesMapper messagesMapper;

    public MessageService(MessagesMapper messagesMapper) {
        this.messagesMapper = messagesMapper;
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("Creating MessageService bean");
    }

    public void addMessage(ChatForm chatForm) {
        ChatMessage newMessage = new ChatMessage();
        newMessage.setUsername(chatForm.getUsername());
        switch (chatForm.getMessageType()) {
            case "Say":
                newMessage.setMessageText(chatForm.getMessageText());
                break;
            case "Shout":
                newMessage.setMessageText(chatForm.getMessageText().toUpperCase());
                break;
            case "Whisper":
                newMessage.setMessageText(chatForm.getMessageText().toLowerCase());
                break;
        }
        messagesMapper.insertMessage(newMessage);
    }

    public List<ChatMessage> getChatMessages() {
        return messagesMapper.getMessages();
    }
}
