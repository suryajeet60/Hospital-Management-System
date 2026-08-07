package com.JavaSpringBoot.Roles_And_Permissions.dto;

import com.JavaSpringBoot.Roles_And_Permissions.entity.type.BloodGroupType;
import lombok.Data;

import java.time.LocalDate;

@Data
public class PatientResponseDto
{
    private Long id;
    private String name;
    private String gender;
    private LocalDate birthDate;
    private BloodGroupType bloodGroup;
}
