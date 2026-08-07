package com.JavaSpringBoot.Roles_And_Permissions.controller;

import com.JavaSpringBoot.Roles_And_Permissions.dto.AppointmentResponseDto;
import com.JavaSpringBoot.Roles_And_Permissions.dto.CreateAppointmentRequestDto;
import com.JavaSpringBoot.Roles_And_Permissions.dto.PatientResponseDto;
import com.JavaSpringBoot.Roles_And_Permissions.service.AppointmentService;
import com.JavaSpringBoot.Roles_And_Permissions.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/patients")
@RequiredArgsConstructor
public class PatientController
{

    private final PatientService patientService;
    private final AppointmentService appointmentService;

    @PostMapping("/appointments")
    public ResponseEntity<AppointmentResponseDto> createNewAppointment(@RequestBody CreateAppointmentRequestDto createAppointmentRequestDto)
    {
        return ResponseEntity.status(HttpStatus.CREATED).body(appointmentService.createNewAppointment(createAppointmentRequestDto));
    }

    @GetMapping("/profile")
    private ResponseEntity<PatientResponseDto> getPatientProfile()
    {
        Long patientId = 4L;
        return ResponseEntity.ok(patientService.getPatientById(patientId));
    }

}
