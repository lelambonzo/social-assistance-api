package com.example.socialassistance.service;

import com.example.socialassistance.dto.ApplicantDTO;
import com.example.socialassistance.model.*;
import com.example.socialassistance.repository.*;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class ApplicantServiceImpl implements ApplicantService {

    private final ApplicantRepository applicantRepository;
    private final SexRepository sexRepository;
    private final MaritalStatusRepository maritalStatusRepository;
    private final VillageRepository villageRepository;

    public ApplicantServiceImpl(ApplicantRepository applicantRepository, SexRepository sexRepository, MaritalStatusRepository maritalStatusRepository, VillageRepository villageRepository) {
        this.applicantRepository = applicantRepository;
        this.sexRepository = sexRepository;
        this.maritalStatusRepository = maritalStatusRepository;
        this.villageRepository = villageRepository;
    }

    @Override
    public List<Applicant> getAllApplicants() {
        return applicantRepository.findAll();
    }

    @Override
    public Applicant getApplicantById(Long id) {
        return applicantRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Applicant not found"));
    }

    @Override
    public Applicant createApplicant(ApplicantDTO applicantDTO) {
        Applicant applicant = new Applicant();
        applicant.setApplicationDate(applicantDTO.getApplicationDate());
        applicant.setFirstName(applicantDTO.getFirstName());
        applicant.setMiddleName(applicantDTO.getMiddleName());
        applicant.setLastName(applicantDTO.getLastName());

        Sex sex = sexRepository.findById(applicantDTO.getSexId())
                .orElseThrow(() -> new RuntimeException("Sex not found"));
        applicant.setSex(sex);

        applicant.setAge(applicantDTO.getAge());

        MaritalStatus maritalStatus = maritalStatusRepository.findById(applicantDTO.getMaritalStatusId())
                .orElseThrow(() -> new RuntimeException("Marital Status not found"));
        applicant.setMaritalStatus(maritalStatus);

        applicant.setIdPassportNumber(applicantDTO.getIdPassportNumber());

        Village village = villageRepository.findById(applicantDTO.getVillageId())
                .orElseThrow(() -> new RuntimeException("Village not found"));
        applicant.setVillage(village);

        applicant.setPostalAddress(applicantDTO.getPostalAddress());
        applicant.setPhysicalAddress(applicantDTO.getPhysicalAddress());
        applicant.setTelephoneContacts(applicantDTO.getTelephoneContacts());
        applicant.setDeclaration(applicantDTO.isDeclaration());

        return applicantRepository.save(applicant);
    }

    @Override
    public Applicant updateApplicant(Long id, ApplicantDTO applicantDTO) {
        Applicant applicant = applicantRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Applicant not found"));

        applicant.setApplicationDate(applicantDTO.getApplicationDate());
        applicant.setFirstName(applicantDTO.getFirstName());
        applicant.setMiddleName(applicantDTO.getMiddleName());
        applicant.setLastName(applicantDTO.getLastName());

        Sex sex = sexRepository.findById(applicantDTO.getSexId())
                .orElseThrow(() -> new RuntimeException("Sex not found"));
        applicant.setSex(sex);

        applicant.setAge(applicantDTO.getAge());

        MaritalStatus maritalStatus = maritalStatusRepository.findById(applicantDTO.getMaritalStatusId())
                .orElseThrow(() -> new RuntimeException("Marital Status not found"));
        applicant.setMaritalStatus(maritalStatus);

        applicant.setIdPassportNumber(applicantDTO.getIdPassportNumber());

        Village village = villageRepository.findById(applicantDTO.getVillageId())
                .orElseThrow(() -> new RuntimeException("Village not found"));
        applicant.setVillage(village);

        applicant.setPostalAddress(applicantDTO.getPostalAddress());
        applicant.setPhysicalAddress(applicantDTO.getPhysicalAddress());
        applicant.setTelephoneContacts(applicantDTO.getTelephoneContacts());
        applicant.setDeclaration(applicantDTO.isDeclaration());

        return applicantRepository.save(applicant);
    }

    @Override
    public void deleteApplicant(Long id) {
        Applicant applicant = applicantRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Applicant not found"));
        applicantRepository.delete(applicant);
    }

    @Override
    public void approveApplicant(Long id) {
        Applicant applicant = applicantRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Applicant not found"));
        applicant.setDeclaration(true);
        applicantRepository.save(applicant);
    }
}
