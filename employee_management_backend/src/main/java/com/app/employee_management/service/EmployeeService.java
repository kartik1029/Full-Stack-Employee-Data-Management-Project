package com.app.employee_management.service;

import com.app.employee_management.dto.EmployeeDTO;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface EmployeeService {
    EmployeeDTO createEmployee(EmployeeDTO dto);
    List<EmployeeDTO> getAllEmployees();
    EmployeeDTO getEmployeeById(Long id);
    EmployeeDTO updateEmployee(Long id, EmployeeDTO dto);
    void deleteEmployee(Long id);
    BulkUploadResult bulkUpload(MultipartFile file) throws Exception;

    public class BulkUploadResult {
        public int processed;
        public int saved;
        public int skipped;
        public List<String> errors;
        public BulkUploadResult() {}
    }
}

