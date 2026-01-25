package com.civicscore.service;

import com.civicscore.entity.*;
import com.civicscore.repository.ViolationRepository;
import com.civicscore.repository.CitizenRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;


@Service
public class ViolationService {
    private final ViolationRepository violationRepository;
    private final CitizenRepository citizenRepository;

    public ViolationService(ViolationRepository violationRepository,
                            CitizenRepository citizenRepository){
        this.violationRepository = violationRepository;
        this.citizenRepository = citizenRepository;

    }

    public Violation addViolation(
            java.util.UUID citizenId,
            Severity severity,
            String description){
        System.out.println("Looking for citizenId = " + citizenId);


        Citizen citizen = citizenRepository.findById(citizenId)
                .orElseThrow(() -> new RuntimeException("Citizen Not Found"));


        //Deduction logic
        int deduction = switch (severity){
            case MINOR -> 5;
            case MAJOR ->20;
            case CRITICAL -> 50;
        };

        citizen.setCurrentScore(
                Math.max(300,citizen.getCurrentScore()- deduction)
        );

        Violation violation = new Violation();
        violation.setCitizen(citizen);
        violation.setSeverity(severity);
        violation.setDescription(description);
        violation.setViolationTime(LocalDateTime.now());

        citizenRepository.save(citizen);
        return violationRepository.save(violation);
    }

}
