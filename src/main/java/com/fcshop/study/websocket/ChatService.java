package com.fcshop.study.websocket;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.Map;

@Service
public class ChatService {
    private final ObjectMapper objectMapper;
    private Map<String, ChatRoom> chatRoom;

    @Autowired
    public ChatService(ObjectMapper objectMapper){
        this.objectMapper = objectMapper;
        this.chatRoom = new LinkedHashMap<>();
    }


}
