package com.hivel.ai.employeeperformancetracker.service;

import com.hivel.ai.employeeperformancetracker.entity.Employee;
import com.hivel.ai.employeeperformancetracker.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }
}