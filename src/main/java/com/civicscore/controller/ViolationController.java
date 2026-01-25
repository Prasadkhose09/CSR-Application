package com.civicscore.controller;

import com.civicscore.entity.Severity;
import com.civicscore.entity.Violation;
import com.civicscore.service.ViolationService;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/violations")
public class ViolationController {

    private final ViolationService service;

    public ViolationController(ViolationService service) {
        this.service = service;
    }

    @PostMapping
    public Violation addViolation(
            @RequestParam UUID citizenId,
            @RequestParam Severity severity,
            @RequestParam String description) {

        return service.addViolation(citizenId, severity, description);
    }

}
