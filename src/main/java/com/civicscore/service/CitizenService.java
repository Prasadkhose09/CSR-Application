package com.civicscore.service;

import com.civicscore.entity.Citizen;
import com.civicscore.entity.Role;
import com.civicscore.repository.CitizenRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CitizenService {

    private final CitizenRepository repository;

    public CitizenService(CitizenRepository repository){
        this.repository = repository;

    }

    public Citizen createCitizen(String name){
        Citizen citizen = new Citizen();
        citizen.setFullName(name);
        citizen.setCurrentScore(750);
        citizen.setRole(Role.CITIZEN);
        return repository.save(citizen);
    }

    public int getCitizenScore(UUID citizenId){
        Citizen citizen = repository.findById(citizenId)
                .orElseThrow(() -> new RuntimeException("Citizen not found"));
           return  citizen.getCurrentScore();

    }
}
