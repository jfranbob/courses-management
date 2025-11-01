package com.jfranbob.coursesmanagement.application.student;

import com.jfranbob.coursesmanagement.application.shared.Result;
import com.jfranbob.coursesmanagement.domain.student.Student;
import com.jfranbob.coursesmanagement.domain.student.StudentRepository;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class GetStudentByIdUseCase {

    private final StudentRepository repository;

    public GetStudentByIdUseCase(StudentRepository repository) {
        this.repository = repository;
    }

    public Result<Student> execute(UUID id) {
        return repository.findById(id)
                .<Result<Student>>map(Result.Success::new)
                .orElseGet(() -> new Result.Failure<>("Student not found with id: " + id));
    }
}
