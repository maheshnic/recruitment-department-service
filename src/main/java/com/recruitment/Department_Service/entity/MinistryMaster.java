package com.recruitment.Department_Service.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "master_ministry", schema = "master")
public class MinistryMaster extends BaseEntity {

    @Column(name = "ministry_name")
    private String ministryName;
}
