package com.example.socialassistance.dto;

import lombok.Data;

import java.util.Date;

@Data
public class ApplicantDTO {
    private Long applicantId;
    private Date applicationDate;
    private String firstName;
    private String middleName;
    private String lastName;
    private Long sexId;
    private int age;
    private Long maritalStatusId;
    private String idPassportNumber;
    private Long villageId;
    private String postalAddress;
    private String physicalAddress;
    private String telephoneContacts;
    private boolean declaration;
}
