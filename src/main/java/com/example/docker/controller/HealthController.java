package com.example.docker.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestController
public class HealthController {
    @Value("${spring.application.name}")
    private String appName;

    @Value("${app.version:1.0.0}")
    private String appVersion;

    @GetMapping("/health")
    public Map<String, Object> health() {
        Map<String, Object> health = new HashMap<>();

        // TODO: 헬스체크 정보 추가
        health.put("status", "UP");
        health.put("application", appName);
        health.put("version", appVersion);
        health.put("timestamp", LocalDateTime.now());

        return health;
    }

    @GetMapping("/")
    public String home() {
        // TODO: 환영 메시지 반환
        return "";
    }

}
