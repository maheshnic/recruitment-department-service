package com.recruitment.Department_Service.restcontroller;

import com.recruitment.Department_Service.Response.ApiResponse;
import com.recruitment.Department_Service.entity.DepartmentMaster;
import com.recruitment.Department_Service.service.MasterService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/master")
@Tag(name = "Department Master Controller")
public class MasterController {

    private final MasterService masterService;

    @GetMapping("department")
    public ResponseEntity<ApiResponse<List<DepartmentMaster>>> getAllDepartments(@RequestHeader(value = "x-Encrypted") String encryptedFlag) {
        masterService.requireEncrypted(encryptedFlag);
        return ApiResponse.success("Department fetched successfully", masterService.getAllDepartments());
    }

    @GetMapping("department/{identifier}")
    public ResponseEntity<ApiResponse<DepartmentMaster>> getRolesByIdentifier(@PathVariable Long identifier,
                                                                              @RequestHeader(value = "x-Encrypted") String encryptedFlag) {

        masterService.requireEncrypted(encryptedFlag);
        return ApiResponse.success("Department fetched successfully", masterService.getDepartment(identifier));
    }
}
