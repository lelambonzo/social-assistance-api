package com.example.socialassistance.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "sex")
@Data
public class Sex {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sexId;

    @Column(nullable = false)
    private String sexDescription;
}
