package com.civicscore.controller;

import com.civicscore.entity.Citizen;
import com.civicscore.repository.*;
import com.civicscore.service.CitizenService;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;


@RestController
@RequestMapping("/citizens")
public class CitizenController {

    private final CitizenService service;

    public CitizenController(CitizenService service){
        this.service = service;

    }

    @PostMapping
    public Citizen create(@RequestParam String name){
        return service.createCitizen(name);
    }

    @GetMapping("/{citizenId}/score")
    public int getCitizenScore(@PathVariable UUID citizenId){
        return service.getCitizenScore(citizenId);
    }





}
