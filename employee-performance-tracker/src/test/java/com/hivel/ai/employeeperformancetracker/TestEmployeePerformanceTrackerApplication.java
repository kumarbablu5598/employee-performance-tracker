package com.hivel.ai.employeeperformancetracker;

import org.springframework.boot.SpringApplication;

public class TestEmployeePerformanceTrackerApplication {

	public static void main(String[] args) {
		SpringApplication.from(EmployeePerformanceTrackerApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
