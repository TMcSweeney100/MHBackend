package com.maynoothmh.backend.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@RestController
@RequestMapping("/chat")
public class ChatController {

    @Value("${openai.api.key}")
    private String OPENAI_API_KEY;

    private final String OPENAI_API_URL = "https://api.openai.com/v1/chat/completions";

    @PostMapping
    public ResponseEntity<Map<String, String>> chat(@RequestBody Map<String, String> request) {
        String userMessage = request.get("message");

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add("Authorization", "Bearer " + OPENAI_API_KEY); // ← avoid setBearerAuth()

        List<Map<String, String>> messages = List.of(
                Map.of("role", "system", "content", "You are a helpful assistant focused on recovery advice and motivation."),
                Map.of("role", "user", "content", userMessage)
        );

        Map<String, Object> body = new HashMap<>();
        body.put("model", "gpt-3.5-turbo");
        body.put("messages", messages);
        body.put("temperature", 0.7);

        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(body, headers);

        RestTemplate restTemplate = new RestTemplate();

        try {
            ResponseEntity<Map> response = restTemplate.postForEntity(OPENAI_API_URL, entity, Map.class);

            List<Map<String, Object>> choices = (List<Map<String, Object>>) response.getBody().get("choices");
            Map<String, Object> message = (Map<String, Object>) choices.get(0).get("message");
            String reply = (String) message.get("content");

            return ResponseEntity.ok(Map.of("reply", reply));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Map.of("reply", "Sorry, something went wrong. Please try again."));
        }
    }
}
