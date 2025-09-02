package com.recruitment.Department_Service.repository;

import com.recruitment.Department_Service.entity.Recruiter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecruiterRepository extends JpaRepository<Recruiter, Long> {

    boolean existsByUserId(Long userId);
    boolean existsByRecruiterId(String recruiterId);
}
