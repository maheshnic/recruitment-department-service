package com.recruitment.Department_Service.service;

import com.recruitment.Department_Service.entity.DepartmentMaster;

import java.util.List;

public interface MasterService {

    List<DepartmentMaster> getAllDepartments();

    DepartmentMaster getDepartment(Long identifier);

    void requireEncrypted(String encryptedFlag);
}
