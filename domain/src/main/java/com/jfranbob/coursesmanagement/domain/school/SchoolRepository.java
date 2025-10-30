package com.jfranbob.coursesmanagement.domain.school;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface SchoolRepository {
    School save(School school);

    Optional<School> findById(UUID id);

    List<School> findAll();

    void delete(UUID id);
}
