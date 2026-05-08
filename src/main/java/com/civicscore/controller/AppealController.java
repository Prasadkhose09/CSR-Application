package com.civicscore.controller;

import com.civicscore.entity.Appeal;
import com.civicscore.entity.AppealStatus;
import com.civicscore.service.AppealService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/appeals")
public class AppealController {

    private final AppealService service;

    public AppealController(AppealService service) {
        this.service = service;
    }

    @GetMapping("/pending")
    public List<Appeal> getPendingAppeals() {
        return service.getAppealsByStatus(AppealStatus.PENDING);
    }

    @PostMapping
    public Appeal raiseAppeal(
            @RequestParam Long violationId,
            @RequestParam String reason) {
        return service.raiseAppeal(violationId, reason);
    }

    @PostMapping("/{appealId}/approve")
    public Appeal approveAppeal(@PathVariable Long appealId) {
        return service.resolveAppeal(appealId, AppealStatus.APPROVED);
    }

    @PostMapping("/{appealId}/reject")
    public Appeal rejectAppeal(@PathVariable Long appealId) {
        return service.resolveAppeal(appealId, AppealStatus.REJECTED);
    }
}
