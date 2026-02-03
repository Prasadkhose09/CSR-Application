package com.civicscore.controller;

import com.civicscore.security.JwtUtil;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @PostMapping("/login")
    public Map<String, String> login(
            @RequestParam String username,
            @RequestParam String role) {

        // TEMP: simulate login (later DB-backed)
        String token = JwtUtil.generateToken(username, role);

        return Map.of("token", token);
    }
}
