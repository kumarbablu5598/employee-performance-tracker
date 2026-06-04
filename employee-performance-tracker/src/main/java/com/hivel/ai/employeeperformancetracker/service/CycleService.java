package com.hivel.ai.employeeperformancetracker.service;

import com.hivel.ai.employeeperformancetracker.dto.CycleSummaryResponse;
import com.hivel.ai.employeeperformancetracker.entity.ReviewCycle;
import com.hivel.ai.employeeperformancetracker.enums.GoalStatus;
import com.hivel.ai.employeeperformancetracker.exception.ResourceNotFoundException;
import com.hivel.ai.employeeperformancetracker.repository.GoalRepository;
import com.hivel.ai.employeeperformancetracker.repository.PerformanceReviewRepository;
import com.hivel.ai.employeeperformancetracker.repository.ReviewCycleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CycleService {

    private final PerformanceReviewRepository performanceReviewRepository;

    private final GoalRepository goalRepository;

    private final ReviewCycleRepository reviewCycleRepository;


    public CycleSummaryResponse getSummary(Long cycleId) {

        ReviewCycle cycle = reviewCycleRepository.findById(cycleId)
                        .orElseThrow(() -> new ResourceNotFoundException("Review cycle not found"));

        Double avgRating =
                performanceReviewRepository.getAverageRating(cycleId);

        String topPerformer =
                performanceReviewRepository.findTopPerformer(cycleId)
                        .stream()
                        .findFirst()
                        .orElse("N/A");

        long completedGoals = goalRepository.countByReviewCycleAndStatus(cycle, GoalStatus.COMPLETED);

        long missedGoals = goalRepository.countByReviewCycleAndStatus(cycle, GoalStatus.MISSED);

        return new CycleSummaryResponse(
                avgRating,
                topPerformer,
                completedGoals,
                missedGoals
        );
    }
}