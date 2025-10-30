package com.jfranbob.coursesmanagement.domain.student;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface StudentRepository {
    Student save(Student student);

    Optional<Student> findById(UUID id);

    List<Student> findAll();

    void delete(UUID id);
}
