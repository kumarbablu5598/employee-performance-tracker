package com.hivel.ai.employeeperformancetracker.repository;

import com.hivel.ai.employeeperformancetracker.entity.PerformanceReview;
import com.hivel.ai.employeeperformancetracker.entity.ReviewCycle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewCycleRepository extends JpaRepository<ReviewCycle, Long> {
}
