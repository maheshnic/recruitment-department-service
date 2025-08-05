package com.recruitment.Department_Service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentDto {
    private String userId;
    private String departmentName;
    private String headOfDepartment;
    private String ministryName;
}