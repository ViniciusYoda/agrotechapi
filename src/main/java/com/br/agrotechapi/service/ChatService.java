package com.br.agrotechapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ChatService {

    @Autowired
    private Environment environment;

    private List<String> agricultureKeywords = Arrays.asList("cultivar", "plantação", "colheita", "solo", "irrigação");

    public String getApiKey() {
        return environment.getProperty("gpt3.api.key");
    }

    public String getChatResponse(String userMessage) {
        String apiKey = getApiKey();

        String apiUrl = "https://api.openai.com/v1/chat/completions";

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + apiKey);
        headers.setContentType(MediaType.APPLICATION_JSON);

        boolean isAgricultureRelated = agricultureKeywords.stream()
                .anyMatch(keyword -> userMessage.toLowerCase().contains(keyword));

        if (isAgricultureRelated) {
            Map<String, Object> systemMessage = Collections.singletonMap("role", "system");
            Map<String, Object> userMessageMap = new HashMap<>();
            userMessageMap.put("role", "user");
            userMessageMap.put("content", userMessage);

            List<Map<String, Object>> messages = new ArrayList<>();
            messages.add(systemMessage);
            messages.add(userMessageMap);

            Map<String, Object> requestBody = new HashMap<>();
            requestBody.put("messages", messages);

            HttpEntity<Map<String, Object>> requestEntity = new HttpEntity<>(requestBody, headers);
            ResponseEntity<Map> response = restTemplate.exchange(apiUrl, HttpMethod.POST, requestEntity, Map.class);

            String chatResponse = (String) ((List<Map<String, Object>>) response.getBody().get("choices")).get(0).get("message");

            return chatResponse;
        } else {
            return "Desculpe, só consigo responder a perguntas relacionadas à agricultura.";
        }
    }
}

