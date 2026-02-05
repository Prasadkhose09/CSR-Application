package com.civicscore.service;

import com.civicscore.entity.Citizen;
import com.civicscore.repository.CitizenRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CitizenService {

    private final CitizenRepository repository;

    public CitizenService(CitizenRepository repository) {
        this.repository = repository;
    }

    public Citizen createCitizen(String name) {
        Citizen citizen = new Citizen();
        citizen.setFullName(name);
        return repository.save(citizen);
    }

    public int getCitizenScore(UUID citizenId) {
        return repository.findById(citizenId)
                .orElseThrow(() -> new RuntimeException("Citizen not found"))
                .getCurrentScore();
    }

    // 🔴 TEMP METHOD FOR MVP
    public Citizen getAnyCitizenForDemo() {
        return repository.findAll()
                .stream()
                .findFirst()
                .orElseThrow(() -> new RuntimeException("No citizens available"));
    }
}
