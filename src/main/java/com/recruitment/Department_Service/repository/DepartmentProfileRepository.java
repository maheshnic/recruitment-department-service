package com.recruitment.Department_Service.repository;

import com.recruitment.Department_Service.model.DepartmentProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentProfileRepository extends JpaRepository<DepartmentProfile, String> {
    boolean existsByUserId(String userId);
}
