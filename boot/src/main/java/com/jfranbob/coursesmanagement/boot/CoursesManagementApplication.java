package com.jfranbob.coursesmanagement.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {
        "com.jfranbob.coursesmanagement.application",
        "com.jfranbob.coursesmanagement.domain",
        "com.jfranbob.coursesmanagement.infrastructure",
        "com.jfranbob.coursesmanagement.apirest"
})
@EnableJpaRepositories(basePackages = "com.jfranbob.coursesmanagement.infrastructure.student")
@EntityScan(basePackages = "com.jfranbob.coursesmanagement.infrastructure.student")
public class CoursesManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoursesManagementApplication.class, args);
	}

}
