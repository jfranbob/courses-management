package com.jfranbob.coursesmanagement.domain.course;

import com.jfranbob.coursesmanagement.domain.shared.Money;

import java.util.Set;
import java.util.UUID;

public record Course(
        UUID id,
        String name,
        String country,
        Set<CourseTag> tags,
        Level level,
        Money price,
        UUID schoolId
) {
}
