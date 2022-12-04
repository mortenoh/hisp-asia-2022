package com.example.future;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/gateway")
public class GatewayController {
    private final ObjectMapper objectMapper;

    @PostMapping
    public ResponseEntity<?> whRequest(@RequestBody Map<String, ?> payload) throws IOException {
        System.err.println("-- Webhook Request Received, data:\n");
        System.err.println(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(payload));

        return ResponseEntity.ok().build();
    }
}
