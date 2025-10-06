package com.app.employee_management.controller;

import com.app.employee_management.dto.EmployeeDTO;
import com.app.employee_management.service.EmployeeService;
import com.app.employee_management.service.EmployeeService.BulkUploadResult;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/employees")
@CrossOrigin(origins = "${app.cors.allowed-origins}")
public class EmployeeController {

    private final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<EmployeeDTO>> getAll() {
        return ResponseEntity.ok(service.getAllEmployees());
    }


    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getEmployeeById(id));
    }

    @PostMapping
    public ResponseEntity<EmployeeDTO> create(@Valid @RequestBody EmployeeDTO dto) {
        EmployeeDTO created = service.createEmployee(dto);
        return ResponseEntity.created(URI.create("/api/employees/" + created.getId())).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmployeeDTO> update(@PathVariable Long id, @Valid @RequestBody EmployeeDTO dto) {
        return ResponseEntity.ok(service.updateEmployee(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        service.deleteEmployee(id);
        return ResponseEntity.noContent().build();
    }

    
    @PostMapping("/bulk")
    public ResponseEntity<BulkUploadResult> uploadBulk(@RequestParam("file") MultipartFile file) throws Exception {
        BulkUploadResult result = service.bulkUpload(file);
        return ResponseEntity.ok(result);
    }
}
