package com.recruitment.Department_Service.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "department_profile", schema = "department")
public class DepartmentProfile {
    @Id
    @GenericGenerator(name = "UUID", strategy = "com.recruitment.Department_Service.util.GenUUID")
    @GeneratedValue(generator = "UUID")
    @Column(name = "department_id", nullable = false, unique = true, updatable = false)
    private String departmentId;

    @Column(name = "user_id", nullable = false, unique = true)
    private String userId;

    @Column(name = "department_name")
    private String departmentName;

    @Column(name = "ministry_name")
    private String ministryName;

    @Column(name = "department_code", unique = true)
    private String departmentCode;

    @Column(name = "head_of_department")
    private String headOfDepartment;

    @Column(name = "designation_of_head")
    private String designationOfHead;

}
