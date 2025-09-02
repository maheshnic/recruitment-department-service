package com.recruitment.Department_Service.repository;

import com.recruitment.Department_Service.entity.DepartmentMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentMasterRepository extends JpaRepository<DepartmentMaster, Long> {
}
