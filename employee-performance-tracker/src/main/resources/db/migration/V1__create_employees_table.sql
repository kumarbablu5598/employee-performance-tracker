CREATE TABLE employees (
                           id BIGINT AUTO_INCREMENT PRIMARY KEY,

                           name VARCHAR(100) NOT NULL,

                           department VARCHAR(50) NOT NULL,

                           role VARCHAR(50) NOT NULL,

                           joining_date DATE NOT NULL,

                           created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP

);