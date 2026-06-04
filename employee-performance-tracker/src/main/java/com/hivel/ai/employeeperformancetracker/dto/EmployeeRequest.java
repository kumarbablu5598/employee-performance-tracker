package com.hivel.ai.employeeperformancetracker.dto;

import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDate;

@Data
public class EmployeeRequest {

    @NotBlank
    private String name;

    @NotBlank
    private String department;

    @NotBlank
    private String role;

    @NotNull
    private LocalDate joiningDate;
}