package com.jfranbob.coursesmanagement.apirest.student;

import com.jfranbob.coursesmanagement.application.shared.Result;
import com.jfranbob.coursesmanagement.application.student.CreateStudentUseCase;
import com.jfranbob.coursesmanagement.application.student.GetAllStudentsUseCase;
import com.jfranbob.coursesmanagement.application.student.GetStudentByIdUseCase;
import com.jfranbob.coursesmanagement.domain.student.Student;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private final CreateStudentUseCase createStudentUseCase;
    private final GetStudentByIdUseCase getStudentByIdUseCase;
    private final GetAllStudentsUseCase getAllStudentsUseCase;

    public StudentController(CreateStudentUseCase createStudentUseCase, GetStudentByIdUseCase getStudentByIdUseCase, GetAllStudentsUseCase getAllStudentsUseCase) {
        this.createStudentUseCase = createStudentUseCase;
        this.getStudentByIdUseCase = getStudentByIdUseCase;
        this.getAllStudentsUseCase = getAllStudentsUseCase;
    }

    @PostMapping
    public ResponseEntity<?> createStudent(@Valid @RequestBody StudentRequest request) {
        var result = createStudentUseCase.execute(request.toCommand());

        return switch (result) {
            case Result.Success<Student> s -> ResponseEntity.ok(s.data());
            case Result.Failure<Student> f -> ResponseEntity.badRequest().body(f.reason());
        };
    }

    @GetMapping("/by-id")
    public ResponseEntity<?> getStudentById(@RequestParam("id") UUID id) {
        var result = getStudentByIdUseCase.execute(id);

        return switch (result) {
            case Result.Success<Student> s -> ResponseEntity.ok(s.data());
            case Result.Failure<Student> f -> ResponseEntity.badRequest().body(f.reason());
        };
    }

    @GetMapping
    public ResponseEntity<?> getAllStudents() {
        var result = getAllStudentsUseCase.execute();

        return switch (result) {
            case Result.Success<List<Student>> s -> ResponseEntity.ok(s.data());
            case Result.Failure<List<Student>> f -> ResponseEntity.badRequest().body(f.reason());
        };
    }
}
