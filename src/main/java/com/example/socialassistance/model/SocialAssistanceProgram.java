package com.example.socialassistance.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "social_assistance_programs")
@Data
public class SocialAssistanceProgram {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long programId;

    @Column(nullable = false)
    private String programDescription;
}
