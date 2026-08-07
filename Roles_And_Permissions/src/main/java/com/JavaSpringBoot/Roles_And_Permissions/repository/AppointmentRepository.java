package com.JavaSpringBoot.Roles_And_Permissions.repository;

import com.JavaSpringBoot.Roles_And_Permissions.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, Long>
{

}
