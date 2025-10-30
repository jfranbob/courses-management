package com.jfranbob.coursesmanagement.domain.student;

import java.util.UUID;
import java.time.LocalDate;

public record Student(
        UUID id,
        String firstName,
        String lastName,
        String email,
        String phone,
        String passportNumber,
        String nationality,
        LocalDate registrationDate
) {
}
