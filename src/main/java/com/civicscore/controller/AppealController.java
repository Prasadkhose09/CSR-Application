package com.civicscore.controller;

import com.civicscore.entity.Appeal;
import com.civicscore.entity.AppealStatus;
import com.civicscore.service.AppealService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/appeals")
public class AppealController {

    private final AppealService service;

    public AppealController(AppealService service) {
        this.service = service;
    }

    // Citizen raises appeal
    @PostMapping
    public Appeal raiseAppeal(
            @RequestParam Long violationId,
            @RequestParam String reason) {

        return service.raiseAppeal(violationId, reason);
    }

    // Authority resolves appeal
    @PutMapping("/{appealId}")
    public Appeal resolveAppeal(
            @PathVariable Long appealId,
            @RequestParam AppealStatus status) {

        return service.resolveAppeal(appealId, status);
    }
}
