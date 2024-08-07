package com.example.socialassistance.controller;

import com.example.socialassistance.dto.ApplicantDTO;
import com.example.socialassistance.model.Applicant;
import com.example.socialassistance.service.ApplicantService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/applicants")
@CrossOrigin(origins = "http://localhost:3000") // Replace with your front-end URL
public class ApplicantController {

    private final ApplicantService applicantService;

    public ApplicantController(ApplicantService applicantService) {
        this.applicantService = applicantService;
    }

    @GetMapping
    public ResponseEntity<List<Applicant>> getAllApplicants() {
        List<Applicant> applicants = applicantService.getAllApplicants();
        return ResponseEntity.ok(applicants);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Applicant> getApplicantById(@PathVariable Long id) {
        Applicant applicant = applicantService.getApplicantById(id);
        return ResponseEntity.ok(applicant);
    }

    @PostMapping
    public ResponseEntity<Applicant> createApplicant(@RequestBody ApplicantDTO applicantDTO) {
        Applicant applicant = applicantService.createApplicant(applicantDTO);
        return ResponseEntity.ok(applicant);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Applicant> updateApplicant(@PathVariable Long id, @RequestBody ApplicantDTO applicantDTO) {
        Applicant applicant = applicantService.updateApplicant(id, applicantDTO);
        return ResponseEntity.ok(applicant);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteApplicant(@PathVariable Long id) {
        applicantService.deleteApplicant(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}/approve")
    public ResponseEntity<Applicant> approveApplicant(@PathVariable Long id) {
        applicantService.approveApplicant(id);
        return ResponseEntity.noContent().build();
    }
}
