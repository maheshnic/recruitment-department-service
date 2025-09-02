package com.recruitment.Department_Service.restcontroller;

import com.recruitment.Department_Service.Response.ApiResponse;
import com.recruitment.Department_Service.dto.RecruiterDTO;
import com.recruitment.Department_Service.service.RecruiterService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/recruiter")
@Tag(name = "Recruiter Controller")
public class RecruiterController {

    private final RecruiterService recruiterService;

    @PostMapping("/register")
    public ResponseEntity<ApiResponse<Object>> registerAdmin(@RequestBody RecruiterDTO dto){
        return recruiterService.registerRecruiter(dto);
    }
}
