package com.jfranbob.coursesmanagement.domain.course;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CourseRepository {
    Course save(Course course);

    Optional<Course> findById(UUID id);

    List<Course> findAll();

    void delete(UUID id);
}
