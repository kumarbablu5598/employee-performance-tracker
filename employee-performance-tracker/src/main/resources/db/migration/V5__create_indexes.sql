CREATE INDEX idx_employee_department
    ON employees(department);

CREATE INDEX idx_review_employee
    ON performance_reviews(employee_id);

CREATE INDEX idx_review_cycle
    ON performance_reviews(review_cycle_id);

CREATE INDEX idx_goal_employee
    ON goals(employee_id);

CREATE INDEX idx_goal_cycle
    ON goals(review_cycle_id);