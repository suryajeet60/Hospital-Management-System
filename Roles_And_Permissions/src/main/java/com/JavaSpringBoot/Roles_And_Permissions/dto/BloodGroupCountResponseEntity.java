package com.JavaSpringBoot.Roles_And_Permissions.dto;

import com.JavaSpringBoot.Roles_And_Permissions.entity.type.BloodGroupType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BloodGroupCountResponseEntity
{
    private BloodGroupType bloodGroupType;
    private Long count;
}
