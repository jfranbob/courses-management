package com.jfranbob.coursesmanagement.domain.enrollment;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface EnrollmentRepository {
    Enrollment save(Enrollment enrollment);

    Optional<Enrollment> findById(UUID id);

    List<Enrollment> findAll();

    void delete(UUID id);
}
