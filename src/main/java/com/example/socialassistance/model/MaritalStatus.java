package com.example.socialassistance.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "marital_status")
@Data
public class MaritalStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long maritalStatusId;

    @Column(nullable = false)
    private String maritalStatusDescription;
}
