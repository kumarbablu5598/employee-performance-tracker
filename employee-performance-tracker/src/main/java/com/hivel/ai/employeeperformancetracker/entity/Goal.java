package com.hivel.ai.employeeperformancetracker.entity;

import com.hivel.ai.employeeperformancetracker.enums.GoalStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "goals")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Goal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Employee employee;

    @ManyToOne(fetch = FetchType.LAZY)
    private ReviewCycle reviewCycle;

    private String title;

    @Enumerated(EnumType.STRING)
    private GoalStatus status;
}
