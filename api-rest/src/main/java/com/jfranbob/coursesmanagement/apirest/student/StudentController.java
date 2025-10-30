package com.jfranbob.coursesmanagement.apirest.student;

import com.jfranbob.coursesmanagement.application.shared.Result;
import com.jfranbob.coursesmanagement.application.student.CreateStudentUseCase;
import com.jfranbob.coursesmanagement.domain.student.Student;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final CreateStudentUseCase createStudentUseCase;

    public StudentController(CreateStudentUseCase createStudentUseCase) {
        this.createStudentUseCase = createStudentUseCase;
    }

    @PostMapping
    public ResponseEntity<?> createStudent(@Valid @RequestBody StudentRequest request) {
        var result = createStudentUseCase.execute(request.toCommand());

        return switch (result) {
            case Result.Success<Student> s -> ResponseEntity.ok(s.data());
            case Result.Failure<Student> f -> ResponseEntity.badRequest().body(f.reason());
        };
    }
}
