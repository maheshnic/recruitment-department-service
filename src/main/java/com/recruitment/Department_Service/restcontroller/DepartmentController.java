package com.recruitment.Department_Service.restcontroller;

import com.recruitment.Department_Service.dto.DepartmentDto;
import com.recruitment.Department_Service.model.DepartmentProfile;
import com.recruitment.Department_Service.repository.DepartmentProfileRepository;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/department")
@Tag(name = "Department Controller")
public class DepartmentController {

    @Autowired
    private DepartmentProfileRepository departmentProfileRepository;

    @PostMapping("/register")
    public ResponseEntity<String> registerAdmin(@RequestBody DepartmentDto departmentDto){

        if(departmentDto.getUserId() == null || departmentDto.getUserId().isBlank())
            return ResponseEntity.badRequest().body("UserId is required for Registration.");

        if(departmentProfileRepository.existsByUserId(departmentDto.getUserId()))
            return ResponseEntity.badRequest().body("Admin Profile already exist for this User.");

        log.debug("User Id: {}, Department Name: {}, Head Of Department: {}", departmentDto.getUserId(),
                departmentDto.getDepartmentName(), departmentDto.getHeadOfDepartment());

        DepartmentProfile departmentProfile = new DepartmentProfile();
        departmentProfile.setUserId(departmentDto.getUserId());
        departmentProfile.setDepartmentName(departmentDto.getDepartmentName());
        departmentProfile.setHeadOfDepartment(departmentDto.getHeadOfDepartment());
        departmentProfile.setMinistryName(departmentDto.getMinistryName());

        departmentProfileRepository.save(departmentProfile);

        return ResponseEntity.ok("Department User Created for User Id: " + departmentDto.getUserId());
    }
}
