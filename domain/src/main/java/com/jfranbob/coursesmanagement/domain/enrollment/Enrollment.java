package com.jfranbob.coursesmanagement.domain.enrollment;

import com.jfranbob.coursesmanagement.domain.shared.Money;

import java.time.LocalDate;
import java.util.UUID;

public record Enrollment(
        UUID id,
        UUID studentId,
        UUID courseId,
        LocalDate enrollmentDate,
        EnrollmentStatus status,
        Money totalPrice
) {
}
