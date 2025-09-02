package com.recruitment.Department_Service.repository;

import com.recruitment.Department_Service.entity.MinistryMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MinistryMasterRepository extends JpaRepository<MinistryMaster, Long> {
}
