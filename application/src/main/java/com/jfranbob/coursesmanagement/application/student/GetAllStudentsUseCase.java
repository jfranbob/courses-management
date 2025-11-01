package com.jfranbob.coursesmanagement.application.student;

import com.jfranbob.coursesmanagement.application.shared.Result;
import com.jfranbob.coursesmanagement.domain.student.Student;
import com.jfranbob.coursesmanagement.domain.student.StudentRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetAllStudentsUseCase {
    private final StudentRepository repository;

    public GetAllStudentsUseCase(StudentRepository repository) {
        this.repository = repository;
    }

    public Result<List<Student>> execute() {
        var students = repository.findAll();
        return students.isEmpty()
                ? new Result.Failure<>("No students found")
                : new Result.Success<>(students);
    }
}
