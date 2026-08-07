package com.JavaSpringBoot.Roles_And_Permissions.service;

import com.JavaSpringBoot.Roles_And_Permissions.entity.Insurance;
import com.JavaSpringBoot.Roles_And_Permissions.entity.Patient;
import com.JavaSpringBoot.Roles_And_Permissions.repository.InsuranceRepository;
import com.JavaSpringBoot.Roles_And_Permissions.repository.PatientRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InsuranceService
{

    private final InsuranceRepository insuranceRepository;
    private final PatientRepository patientRepository;

    @Transactional
    public Patient assignInsuranceToPatient(Insurance insurance, Long patientId)
    {
        Patient patient = patientRepository.findById(patientId)
                .orElseThrow(() -> new EntityNotFoundException("Patient not found with id: " + patientId));

        patient.setInsurance(insurance);
        insurance.setPatient(patient);

        return patient;
    }

    @Transactional
    public Patient disaccociateInsuranceFromPatient(Long patientId)
    {
        Patient patient = patientRepository.findById(patientId)
                .orElseThrow(() -> new EntityNotFoundException("Patient not found with id: " + patientId));

        patient.setInsurance(null);
        return patient;
    }

}
