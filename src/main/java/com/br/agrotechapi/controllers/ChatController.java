package com.br.agrotechapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@PostMapping("/ask")
public class ChatController {
public String askQuestion(@RequestBody Map<String, String> requestData) {

    String pergunta = requestData.get("quest");
    String quest = INTRO_TEXT + " " + pergunta;

    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);
    headers.setBearerAuth(API_KEY);

    Map<String, Object> requestBody = new LinkedHashMap<>();
    requestBody.put("model", "gpt-3.5-turbo");
    List<Map<String, String>> messages = new ArrayList<>();
    Map<String, String> message = new HashMap<>();
    message.put("role", "user");
    message.put("content", quest);
    messages.add(message);
    requestBody.put("messages", messages);

    HttpEntity<Map<String, Object>> entity = new HttpEntity<>(requestBody, headers);

    ResponseEntity<String> response = restTemplate.postForEntity(
            "https://api.openai.com/v1/chat/completions",
            entity,
            String.class
    );

    String responseBody = response.getBody();

    // Process responseBody as needed
    
    return responseBody;
}
}

