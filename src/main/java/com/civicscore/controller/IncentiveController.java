package com.civicscore.controller;

import com.civicscore.entity.Citizen;
import com.civicscore.entity.CitizenIncentiveStatus;
import com.civicscore.repository.CitizenRepository;
import com.civicscore.repository.CitizenIncentiveStatusRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/incentives")
public class IncentiveController {

    private final CitizenRepository citizenRepository;
    private final CitizenIncentiveStatusRepository statusRepository;

    public IncentiveController(CitizenRepository citizenRepository,
                               CitizenIncentiveStatusRepository statusRepository) {
        this.citizenRepository = citizenRepository;
        this.statusRepository = statusRepository;
    }

    @GetMapping("/{citizenId}")
    public List<CitizenIncentiveStatus> getIncentives(@PathVariable UUID citizenId) {

        Citizen citizen = citizenRepository.findById(citizenId)
                .orElseThrow(() -> new RuntimeException("Citizen not found"));

        return statusRepository.findByCitizen(citizen);
    }
}
