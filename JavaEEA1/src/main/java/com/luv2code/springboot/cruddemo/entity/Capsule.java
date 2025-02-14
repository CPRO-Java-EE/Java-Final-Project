package com.luv2code.springboot.cruddemo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@Entity
public class Capsule {

    // Getters and Setters
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int capsuleId;

    private int userId;

    private String title;

    private LocalDateTime creationDate;

    private LocalDateTime lockDate;

    private String status;

    public Capsule() {}

}