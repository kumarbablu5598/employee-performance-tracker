package com.hivel.ai.employeeperformancetracker.dto;

import lombok.*;

@Data
@AllArgsConstructor
public class CycleSummaryResponse {

    private Double averageRating;
    private String topPerformer;
    private Long completedGoals;
    private Long missedGoals;
}