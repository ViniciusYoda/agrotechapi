package com.br.agrotechapi.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.agrotechapi.service.ChatService;

@RestController
@RequestMapping("/api/chat")
public class ChatController {
    
    @Autowired
    private ChatService chatService;

    @PostMapping
    public ResponseEntity<String> chatWithBot(@RequestBody Map<String, String> requestBody) {
        String userMessage = requestBody.get("message");
        String chatbotResponse = chatService.getChatResponse(userMessage);
        return ResponseEntity.ok(chatbotResponse);
    }
}
