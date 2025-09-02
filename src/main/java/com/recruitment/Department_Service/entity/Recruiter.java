package com.recruitment.Department_Service.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "recruiter_profile", schema = "recruiter")
public class Recruiter extends BaseEntity {

    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Column(name = "recruiter_id", nullable = false)
    private String recruiterId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id", nullable = false)
    private DepartmentMaster departmentId;

    @Column(name = "head_of_department", nullable = false)
    private String headOfDepartment;

    @Column(name = "designation_of_head", nullable = false)
    private String designationOfHead;
}
