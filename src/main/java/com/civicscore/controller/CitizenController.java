package com.civicscore.controller;

import com.civicscore.entity.Citizen;
import com.civicscore.service.CitizenService;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/citizens")
public class CitizenController {

    private final CitizenService service;

    public CitizenController(CitizenService service) {
        this.service = service;
    }

    // ----------------------------
    // CREATE CITIZEN (ADMIN / SETUP)
    // ----------------------------
    @PostMapping
    public Citizen create(@RequestParam String name) {
        return service.createCitizen(name);
    }

    // ----------------------------
    // GET SCORE BY ID (ADMIN / INTERNAL)
    // ----------------------------
    @GetMapping("/{citizenId}/score")
    public int getCitizenScore(@PathVariable UUID citizenId) {
        return service.getCitizenScore(citizenId);
    }

    // ----------------------------
    // GET LOGGED-IN CITIZEN (CITIZEN DASHBOARD)
    // ----------------------------
    @GetMapping("/me")
    public Citizen getMyCitizen(Authentication authentication) {

        String role = authentication.getAuthorities()
                .iterator()
                .next()
                .getAuthority();

        // TEMP MVP LOGIC
        // If logged-in user is a citizen, return a demo/first citizen
        if ("ROLE_CITIZEN".equals(role)) {
            return service.getAnyCitizenForDemo();
        }

        throw new RuntimeException("Only citizens can access this endpoint");
    }
}
