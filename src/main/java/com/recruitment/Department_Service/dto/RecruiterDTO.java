package com.recruitment.Department_Service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RecruiterDTO {
    private Long userId;
    private String recruiterId;
    private Long departmentId;
    private String headOfDepartment;
    private String designationOfHead;
}