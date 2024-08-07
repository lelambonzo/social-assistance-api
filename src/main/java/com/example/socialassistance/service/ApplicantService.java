package com.example.socialassistance.service;

import com.example.socialassistance.dto.ApplicantDTO;
import com.example.socialassistance.model.Applicant;

import java.util.List;

public interface ApplicantService {
    List<Applicant> getAllApplicants();

    Applicant getApplicantById(Long id);

    Applicant createApplicant(ApplicantDTO applicantDTO);

    Applicant updateApplicant(Long id, ApplicantDTO applicantDTO);

    void deleteApplicant(Long id);

    void approveApplicant(Long id);
}
