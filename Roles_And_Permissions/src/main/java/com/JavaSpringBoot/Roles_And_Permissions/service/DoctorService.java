package com.JavaSpringBoot.Roles_And_Permissions.service;

import com.JavaSpringBoot.Roles_And_Permissions.dto.DoctorResponseDto;
import com.JavaSpringBoot.Roles_And_Permissions.dto.OnboardDoctorRequestDto;
import com.JavaSpringBoot.Roles_And_Permissions.entity.Doctor;
import com.JavaSpringBoot.Roles_And_Permissions.entity.User;
import com.JavaSpringBoot.Roles_And_Permissions.entity.type.RoleType;
import com.JavaSpringBoot.Roles_And_Permissions.repository.DoctorRepository;
import com.JavaSpringBoot.Roles_And_Permissions.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class DoctorService
{

    private final DoctorRepository doctorRepository;
    private final ModelMapper modelMapper;
    private final UserRepository userRepository;

    public List<DoctorResponseDto> getAllDoctors()
    {
        return doctorRepository.findAll()
                .stream()
                .map(doctor -> modelMapper.map(doctor, DoctorResponseDto.class))
                .collect(Collectors.toList());
    }

    @Transactional
    public DoctorResponseDto onBoardNewDoctor(OnboardDoctorRequestDto onBoardDoctorRequestDto)
    {
        User user = userRepository.findById(onBoardDoctorRequestDto.getUserId()).orElseThrow();

        if(doctorRepository.existsById(onBoardDoctorRequestDto.getUserId()))
        {
            throw new IllegalArgumentException("Already a doctor");
        }

        Doctor doctor = Doctor.builder()
                .name(onBoardDoctorRequestDto.getName())
                .specialization(onBoardDoctorRequestDto.getSpecialization())
                .user(user)
                .build();

        user.getRoles().add(RoleType.DOCTOR);

        return modelMapper.map(doctorRepository.save(doctor), DoctorResponseDto.class);
    }
}
