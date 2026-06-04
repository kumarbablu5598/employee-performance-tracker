CREATE TABLE goals (
                       id BIGINT AUTO_INCREMENT PRIMARY KEY,

                       employee_id BIGINT NOT NULL,

                       review_cycle_id BIGINT NOT NULL,

                       title VARCHAR(255) NOT NULL,

                       status VARCHAR(20) NOT NULL,

                       CONSTRAINT fk_goal_employee
                           FOREIGN KEY (employee_id)
                               REFERENCES employees(id),

                       CONSTRAINT fk_goal_cycle
                           FOREIGN KEY (review_cycle_id)
                               REFERENCES review_cycles(id),

                       CONSTRAINT chk_goal_status
                           CHECK (status IN ('PENDING', 'COMPLETED', 'MISSED'))
);