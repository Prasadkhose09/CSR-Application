package com.civicscore.service;

import com.civicscore.entity.Citizen;
import com.civicscore.repository.CitizenRepository;
import org.springframework.stereotype.Service;

@Service
public class CitizenService {

    private final CitizenRepository repository;

    public CitizenService(CitizenRepository repository){
        this.repository = repository;

    }

    public Citizen createCitizen(String name){
        Citizen citizen = new Citizen();
        citizen.setFullName(name);
        return repository.save(citizen);
    }
}
