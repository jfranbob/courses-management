package com.jfranbob.coursesmanagement.application.student;

import com.jfranbob.coursesmanagement.application.shared.Result;
import com.jfranbob.coursesmanagement.domain.student.Student;
import com.jfranbob.coursesmanagement.domain.student.StudentRepository;
import org.springframework.stereotype.Component;

@Component
public class CreateStudentUseCase {
    private final StudentRepository repository;

    public CreateStudentUseCase(StudentRepository repository) {
        this.repository = repository;
    }

    public Result<Student> execute(CreateStudentCommand command) {
        try {
            var student = command.toStudent();
            var saved = repository.save(student);
            return new Result.Success<>(saved);
        } catch (Exception e) {
            return new Result.Failure<>("Error saving student: " + e.getMessage());
        }
    }
}
