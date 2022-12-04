package com.example.future;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Map;

@Log4j2
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/gateway")
public class GatewayController {
    private final ObjectMapper objectMapper;

    @PostMapping
    public ResponseEntity<?> whRequest(@RequestBody Map<String, ?> payload) throws IOException {
        log.info("Webhook received:");
        System.err.println(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(payload));

        return ResponseEntity.ok().build();
    }
}
