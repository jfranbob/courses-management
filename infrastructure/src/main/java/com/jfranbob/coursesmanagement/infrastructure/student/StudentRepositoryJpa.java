package com.jfranbob.coursesmanagement.infrastructure.student;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface StudentRepositoryJpa extends JpaRepository<StudentEntity, UUID> {
}
