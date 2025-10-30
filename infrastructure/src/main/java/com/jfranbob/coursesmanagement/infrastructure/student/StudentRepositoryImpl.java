package com.jfranbob.coursesmanagement.infrastructure.student;

import com.jfranbob.coursesmanagement.domain.student.Student;
import com.jfranbob.coursesmanagement.domain.student.StudentRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class StudentRepositoryImpl implements StudentRepository {
    private final StudentRepositoryJpa jpa;
    private final StudentMapper mapper;

    public StudentRepositoryImpl(StudentRepositoryJpa jpa, StudentMapper mapper) {
        this.jpa = jpa;
        this.mapper = mapper;
    }

    @Override
    public Student save(Student student) {
        var entity = this.mapper.toEntity(student);
        this.jpa.save(entity);
        return student;
    }

    @Override
    public Optional<Student> findById(UUID id) {
        return jpa.findById(id).map(this.mapper::toDomain);
    }

    @Override
    public List<Student> findAll() {
        return jpa.findAll().stream()
                .map(this.mapper::toDomain)
                .toList();
    }

    @Override
    public void delete(UUID id) {
        jpa.deleteById(id);
    }
}
