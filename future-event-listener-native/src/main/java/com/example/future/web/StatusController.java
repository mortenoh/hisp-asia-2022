package com.example.future.web;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/status")
public class StatusController {
    @GetMapping
    public ResponseEntity<Response> getStatus() {
        Response response = new Response(Status.OK, "Hello World");
        return ResponseEntity.ok(response);
    }
}


enum Status {
    OK, ERROR
}

record Response(Status status, String message) {
};