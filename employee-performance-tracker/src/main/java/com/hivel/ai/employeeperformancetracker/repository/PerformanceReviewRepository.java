package com.hivel.ai.employeeperformancetracker.repository;

import com.hivel.ai.employeeperformancetracker.entity.PerformanceReview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PerformanceReviewRepository extends JpaRepository<PerformanceReview, Long> {

    List<PerformanceReview> findByEmployeeId(Long employeeId);

    @Query("SELECT AVG(r.rating) FROM PerformanceReview r WHERE r.reviewCycle.id = :cycleId")
    Double getAverageRating(Long cycleId);

    @Query("""
        select r.employee.name
        from PerformanceReview r
        where r.reviewCycle.id=:cycleId
        group by r.employee.name
        order by avg(r.rating) desc
    """)
    List<String> findTopPerformer(@Param("cycleId") Long cycleId);

}