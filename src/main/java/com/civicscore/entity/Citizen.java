package com.civicscore.entity;


import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Citizen {

    @Id
    @GeneratedValue
    private UUID citizenId;

    private String fullName;

    private int currentScore =750;

}
