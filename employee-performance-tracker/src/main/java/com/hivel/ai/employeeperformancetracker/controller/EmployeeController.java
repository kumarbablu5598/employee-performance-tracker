package com.hivel.ai.employeeperformancetracker.controller;

import com.hivel.ai.employeeperformancetracker.dto.EmployeeRequest;
import com.hivel.ai.employeeperformancetracker.entity.Employee;
import com.hivel.ai.employeeperformancetracker.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employees")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @PostMapping
    public Employee create(@RequestBody EmployeeRequest req) {

        Employee emp = new Employee();
        emp.setName(req.getName());
        emp.setDepartment(req.getDepartment());
        emp.setRole(req.getRole());
        emp.setJoiningDate(req.getJoiningDate());

        return employeeService.save(emp);
    }
}