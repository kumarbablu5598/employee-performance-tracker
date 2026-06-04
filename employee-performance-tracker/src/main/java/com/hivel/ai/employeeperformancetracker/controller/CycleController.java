package com.hivel.ai.employeeperformancetracker.controller;

import com.hivel.ai.employeeperformancetracker.dto.CycleSummaryResponse;
import com.hivel.ai.employeeperformancetracker.service.CycleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cycles")
@RequiredArgsConstructor
public class CycleController {

    private final CycleService cycleService;

    @GetMapping("/summary/{id}")
    public CycleSummaryResponse getSummary(@PathVariable Long id) {

        return cycleService.getSummary(id);
    }
}