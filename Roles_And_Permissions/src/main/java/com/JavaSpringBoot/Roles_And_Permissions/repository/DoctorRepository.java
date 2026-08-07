package com.JavaSpringBoot.Roles_And_Permissions.repository;

import com.JavaSpringBoot.Roles_And_Permissions.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, Long>
{

}