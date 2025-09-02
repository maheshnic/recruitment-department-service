package com.recruitment.Department_Service.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
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
@Table(name = "master_department", schema = "master")
public class DepartmentMaster extends BaseEntity {

    @Column(name = "department_code")
    private String departmentCode;

    @Column(name = "department_name")
    private String departmentName;

    @ManyToOne
    @JoinColumn(name = "ministry_id", referencedColumnName = "id", nullable = false)
    @JsonManagedReference
    private MinistryMaster ministryId;
}
