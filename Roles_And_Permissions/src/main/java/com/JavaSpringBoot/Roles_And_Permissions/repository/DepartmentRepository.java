package com.JavaSpringBoot.Roles_And_Permissions.repository;

import com.JavaSpringBoot.Roles_And_Permissions.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long>
{

}