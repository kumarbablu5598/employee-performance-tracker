package com.hivel.ai.employeeperformancetracker.repository;

import com.hivel.ai.employeeperformancetracker.entity.Goal;
import com.hivel.ai.employeeperformancetracker.entity.ReviewCycle;
import com.hivel.ai.employeeperformancetracker.enums.GoalStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GoalRepository extends JpaRepository<Goal, Long> {
    List<Goal> findByReviewCycleId(Long cycleId);
    long countByReviewCycleAndStatus(ReviewCycle cycle, GoalStatus status);
}
