package com.recruitment.Department_Service.serviceImpl;

import com.recruitment.Department_Service.entity.DepartmentMaster;
import com.recruitment.Department_Service.exception.NotFoundException;
import com.recruitment.Department_Service.repository.DepartmentMasterRepository;
import com.recruitment.Department_Service.service.MasterService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class MasterServiceImpl implements MasterService {

    private final DepartmentMasterRepository departmentMasterRepository;

    @Override
    public List<DepartmentMaster> getAllDepartments() {
        return departmentMasterRepository.findAll();
    }

    @Override
    public DepartmentMaster getDepartment(Long identifier) {
        return this.departmentMasterRepository.findById(identifier)
                .orElseThrow(() -> new NotFoundException("Department not found"));
    }

    @Override
    public void requireEncrypted(String encryptedFlag) {
        if (encryptedFlag == null) {
            throw new IllegalArgumentException("Missing X-Encrypted header");
        }
        String v = encryptedFlag.trim();
        if (!(v.equalsIgnoreCase("true") || v.equals("1"))) {
            throw new IllegalArgumentException("Invalid X-Encrypted header (expected 'true' or '1')");
        }
    }
}
