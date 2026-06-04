package com.hivel.ai.employeeperformancetracker.dto;

import jakarta.validation.constraints.*;
import lombok.*;

@Data
public class ReviewRequest {

    @NotNull
    private Long employeeId;

    @NotNull
    private Long reviewCycleId;

    @Min(1)
    @Max(5)
    private Integer rating;

    private String reviewerNotes;
}