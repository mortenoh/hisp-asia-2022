package com.example.future;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

import java.io.IOException;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/gateway")
public class GatewayController {
    private final ObjectMapper objectMapper;

    @PostMapping
    public ResponseEntity<?> whRequest(@RequestBody Map<String, ?> payload, @RequestHeader("Authorization") String token) throws IOException {
        if (!"ApiToken EB3F6799-AA5A-47E8-B6B7-97EA54EB3873".equals(token)) {
            throw new HttpClientErrorException(HttpStatusCode.valueOf(401));
        }

        System.err.println("-- Webhook Request Received, data:\n");
        System.err.println(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(payload));

        return ResponseEntity.ok().build();
    }
}
