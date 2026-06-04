CREATE TABLE review_cycles (
                               id BIGINT AUTO_INCREMENT PRIMARY KEY,

                               name VARCHAR(50) NOT NULL UNIQUE,

                               start_date DATE NOT NULL,

                               end_date DATE NOT NULL,

                               CONSTRAINT chk_review_cycle_dates
                                   CHECK (start_date < end_date)
);