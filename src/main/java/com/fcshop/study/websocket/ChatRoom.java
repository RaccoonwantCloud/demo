package com.fcshop.study.websocket;

import org.springframework.web.socket.WebSocketSession;

import java.util.HashSet;
import java.util.Set;

public class ChatRoom {

    private String id;
    private String name;
    private Set<WebSocketSession> sessions = new HashSet<>();

    public void handleAction(WebSocketSession session, ChatMessage chatMessage){

    }



}
