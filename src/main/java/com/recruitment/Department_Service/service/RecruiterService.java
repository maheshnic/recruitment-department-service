package com.recruitment.Department_Service.service;

import com.recruitment.Department_Service.Response.ApiResponse;
import com.recruitment.Department_Service.dto.RecruiterDTO;
import org.springframework.http.ResponseEntity;

public interface RecruiterService {

    ResponseEntity<ApiResponse<Object>> registerRecruiter(RecruiterDTO dto);
}
