package com.civicscore.service;

import com.civicscore.entity.*;
import com.civicscore.repository.ViolationRepository;
import com.civicscore.repository.CitizenRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import com.civicscore.repository.ScoreHistoryRepository;


@Service
public class ViolationService {

    private final ViolationRepository violationRepository;
    private final CitizenRepository citizenRepository;
    private final ScoreHistoryRepository scoreHistoryRepository;


    public ViolationService(ViolationRepository violationRepository,
                            CitizenRepository citizenRepository, ScoreHistoryRepository scoreHistoryRepository){
        this.violationRepository = violationRepository;
        this.citizenRepository = citizenRepository;

        this.scoreHistoryRepository = scoreHistoryRepository;
    }

    public Violation addViolation(
            java.util.UUID citizenId,
            Severity severity,
            String description){


        Citizen citizen = citizenRepository.findById(citizenId)
                .orElseThrow(() -> new RuntimeException("Citizen Not Found"));


        int oldScore = citizen.getCurrentScore();



        //Deduction logic
        int deduction = switch (severity){
            case MINOR -> 5;
            case MAJOR ->20;
            case CRITICAL -> 50;
        };

        int newScore = Math.max(300,oldScore-deduction);
        citizen.setCurrentScore(newScore);

        Violation violation = new Violation();
        violation.setCitizen(citizen);
        violation.setSeverity(severity);
        violation.setDescription(description);
        violation.setViolationTime(LocalDateTime.now());

        citizenRepository.save(citizen);
        Violation savedViolation = violationRepository.save(violation);


        ScoreHistory history = new ScoreHistory();
        history.setCitizen(citizen);
        history.setScoreBefore(oldScore);
        history.setScoreAfter(newScore);
        history.setReason("Violation: " + description);
        history.setChagedAt(java.time.LocalDateTime.now());
        scoreHistoryRepository.save(history);

        return savedViolation;
    }

}
