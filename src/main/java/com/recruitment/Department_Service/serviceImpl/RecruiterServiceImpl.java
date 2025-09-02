package com.recruitment.Department_Service.serviceImpl;

import com.recruitment.Department_Service.Response.ApiResponse;
import com.recruitment.Department_Service.dto.RecruiterDTO;
import com.recruitment.Department_Service.entity.DepartmentMaster;
import com.recruitment.Department_Service.entity.Recruiter;
import com.recruitment.Department_Service.repository.RecruiterRepository;
import com.recruitment.Department_Service.service.MasterService;
import com.recruitment.Department_Service.service.RecruiterService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class RecruiterServiceImpl implements RecruiterService {

    private final RecruiterRepository recruiterRepository;
    private final MasterService masterService;

    @Override
    @Transactional
    public ResponseEntity<ApiResponse<Object>> registerRecruiter(RecruiterDTO dto) {

        if (dto == null || dto.getUserId() == null || dto.getDepartmentId() == null || isBlank(dto.getRecruiterId())
                || isBlank(dto.getHeadOfDepartment()) || isBlank(dto.getDesignationOfHead())) {
            return ApiResponse.badRequest("Required fields are missing", null);
        }

        String rid = dto.getRecruiterId().trim();

        if (recruiterRepository.existsByUserId(dto.getUserId())) {
            return ApiResponse.badRequest("Recruiter already registered for this user", null);
        }
        if (recruiterRepository.existsByRecruiterId(rid)) {
            return ApiResponse.badRequest("RecruiterId already exists", null);
        }

        DepartmentMaster departmentMaster = masterService.getDepartment(dto.getDepartmentId());

        Recruiter recruiter = new Recruiter();
        recruiter.setUserId(dto.getUserId());
        recruiter.setRecruiterId(rid);
        recruiter.setDepartmentId(departmentMaster);
        recruiter.setHeadOfDepartment(dto.getHeadOfDepartment());
        recruiter.setDesignationOfHead(dto.getDesignationOfHead());
        recruiterRepository.save(recruiter);

        log.info("Recruiter registered: userId={}, recruiterId={}", dto.getUserId(), rid);
        return ApiResponse.created("Recruiter registered successfully");
    }

    private static boolean isBlank(String s) {
        return s == null || s.trim().isEmpty();
    }
}
