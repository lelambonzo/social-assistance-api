package com.example.socialassistance.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "applicants")
@Data
public class Applicant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long applicantId;

    @Column(nullable = false)
    private Date applicationDate;

    @Column(nullable = false)
    private String firstName;

    private String middleName;

    @Column(nullable = false)
    private String lastName;

    @ManyToOne
    @JoinColumn(name = "sex_id")
    private Sex sex;

    @Column(nullable = false)
    private int age;

    @ManyToOne
    @JoinColumn(name = "marital_status_id")
    private MaritalStatus maritalStatus;

    @Column(nullable = false, length = 20)
    private String idPassportNumber;

    @ManyToOne
    @JoinColumn(name = "village_id")
    private Village village;

    private String postalAddress;

    private String physicalAddress;

    private String telephoneContacts;

    private boolean declaration;
}
