package com.app.employee_management.service;

import com.app.employee_management.dto.EmployeeDTO;
import com.app.employee_management.exception.ResourceNotFoundException;
import com.app.employee_management.model.Employee;
import com.app.employee_management.repository.EmployeeRepository;

import com.opencsv.CSVReader;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository repo;

    public EmployeeServiceImpl(EmployeeRepository repo) {
        this.repo = repo;
    }
    
    public List<EmployeeDTO> getAllEmployees() {
        return repo.findAll()
                .stream()
                .map(this::toDto)
                .toList();
    }

    private EmployeeDTO toDto(Employee e) {
        return new EmployeeDTO(e.getId(), e.getName(), e.getEmail(), e.getPosition());
    }

    private Employee toEntity(EmployeeDTO dto) {
        Employee e = new Employee();
        e.setName(dto.getName());
        e.setEmail(dto.getEmail());
        e.setPosition(dto.getPosition());
        return e;
    }

    @Override
    public EmployeeDTO createEmployee(EmployeeDTO dto) {
        // email unique check
        repo.findByEmail(dto.getEmail()).ifPresent(e -> {
            throw new org.springframework.dao.DataIntegrityViolationException("Email already exists");
        });
        Employee saved = repo.save(toEntity(dto));
        return toDto(saved);
    }

    @Override
    public EmployeeDTO getEmployeeById(Long id) {
        Employee e = repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee not found with id " + id));
        return toDto(e);
    }

    @Override
    public EmployeeDTO updateEmployee(Long id, EmployeeDTO dto) {
        Employee e = repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee not found with id " + id));
        // if email changed, check uniqueness
        if (!e.getEmail().equals(dto.getEmail())) {
            repo.findByEmail(dto.getEmail()).ifPresent(existing -> {
                throw new org.springframework.dao.DataIntegrityViolationException("Email already exists");
            });
        }
        e.setName(dto.getName());
        e.setEmail(dto.getEmail());
        e.setPosition(dto.getPosition());
        Employee updated = repo.save(e);
        return toDto(updated);
    }

    @Override
    public void deleteEmployee(Long id) {
        Employee e = repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee not found with id " + id));
        repo.delete(e);
    }

    @Override
    public BulkUploadResult bulkUpload(MultipartFile file) throws Exception {
        BulkUploadResult result = new BulkUploadResult();
        result.errors = new ArrayList<>();
        int processed = 0;
        int saved = 0;
        int skipped = 0;

        try (Reader r = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
            CSVReader csvReader = new CSVReader(r);
            String[] nextLine;
            boolean first = true;
            while ((nextLine = csvReader.readNext()) != null) {
                // skip header if present
                if (first) {
                    first = false;
                    // naive header detection: if first cell contains "name" or "email", skip
                    String lower0 = nextLine[0].toLowerCase();
                    if (lower0.contains("name") || lower0.contains("email")) {
                        continue;
                    }
                }
                processed++;
                if (nextLine.length < 3) {
                    result.errors.add("Row " + processed + " invalid columns");
                    skipped++;
                    continue;
                }
                String name = nextLine[0].trim();
                String email = nextLine[1].trim();
                String position = nextLine[2].trim();
                if (name.isEmpty() || email.isEmpty() || position.isEmpty()) {
                    result.errors.add("Row " + processed + " has empty field");
                    skipped++;
                    continue;
                }

                // simple email check
                if (!email.contains("@")) {
                    result.errors.add("Row " + processed + " invalid email: " + email);
                    skipped++;
                    continue;
                }

                // skip if email already exists
                if (repo.findByEmail(email).isPresent()) {
                    skipped++;
                    continue;
                }
                Employee e = new Employee(name, email, position);
                repo.save(e);
                saved++;
            }
        } catch (IOException ex) {
            throw new Exception("Failed to read CSV: " + ex.getMessage());
        }

        result.processed = processed;
        result.saved = saved;
        result.skipped = skipped;
        return result;
    }
}

