CREATE TABLE performance_reviews (
                                     id BIGINT AUTO_INCREMENT PRIMARY KEY,

                                     employee_id BIGINT NOT NULL,

                                     review_cycle_id BIGINT NOT NULL,

                                     rating INTEGER NOT NULL,

                                     reviewer_notes CLOB,

                                     submitted_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

                                     CONSTRAINT fk_review_employee
                                         FOREIGN KEY (employee_id)
                                             REFERENCES employees(id),

                                     CONSTRAINT fk_review_cycle
                                         FOREIGN KEY (review_cycle_id)
                                             REFERENCES review_cycles(id),

                                     CONSTRAINT chk_rating
                                         CHECK (rating BETWEEN 1 AND 5)
);