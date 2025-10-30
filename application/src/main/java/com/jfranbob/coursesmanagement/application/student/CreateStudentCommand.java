package com.jfranbob.coursesmanagement.application.student;

import com.jfranbob.coursesmanagement.domain.student.Student;

import java.time.LocalDate;

public record CreateStudentCommand(
        String firstName,
        String lastName,
        String email,
        String phone,
        String passportNumber,
        String nationality
) {
    public Student toStudent() {
        return new Student(
                java.util.UUID.randomUUID(),
                firstName,
                lastName,
                email,
                phone,
                passportNumber,
                nationality,
                LocalDate.now()
        );
    }
}
