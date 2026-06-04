package com.hivel.ai.employeeperformancetracker.controller;

import com.hivel.ai.employeeperformancetracker.dto.ReviewRequest;
import com.hivel.ai.employeeperformancetracker.entity.PerformanceReview;
import com.hivel.ai.employeeperformancetracker.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reviews")
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewService reviewService;

    @PostMapping
    public PerformanceReview submit(@RequestBody ReviewRequest req) {
        return reviewService.submitReview(req);
    }
}