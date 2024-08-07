package com.example.socialassistance.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "village")
@Data
public class Village {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long villageId;

    @Column(nullable = false)
    private String villageName;
}
