package com.hivel.ai.employeeperformancetracker.service;

import com.hivel.ai.employeeperformancetracker.dto.ReviewRequest;
import com.hivel.ai.employeeperformancetracker.entity.Employee;
import com.hivel.ai.employeeperformancetracker.entity.PerformanceReview;
import com.hivel.ai.employeeperformancetracker.entity.ReviewCycle;
import com.hivel.ai.employeeperformancetracker.exception.ResourceNotFoundException;
import com.hivel.ai.employeeperformancetracker.repository.EmployeeRepository;
import com.hivel.ai.employeeperformancetracker.repository.PerformanceReviewRepository;
import com.hivel.ai.employeeperformancetracker.repository.ReviewCycleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class ReviewService {

    private final PerformanceReviewRepository performanceReviewRepository;

    private final EmployeeRepository employeeRepository;

    private final ReviewCycleRepository reviewCycleRepository;

    public PerformanceReview submitReview(ReviewRequest req) {

        Employee emp = employeeRepository.findById(req.getEmployeeId())
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found"));

        ReviewCycle cycle = reviewCycleRepository.findById(req.getReviewCycleId())
                .orElseThrow(() -> new ResourceNotFoundException("Cycle not found"));

        PerformanceReview review = new PerformanceReview();
        review.setEmployee(emp);
        review.setReviewCycle(cycle);
        review.setRating(req.getRating());
        review.setReviewerNotes(req.getReviewerNotes());
        review.setSubmittedAt(LocalDateTime.now());

        return performanceReviewRepository.save(review);
    }
}