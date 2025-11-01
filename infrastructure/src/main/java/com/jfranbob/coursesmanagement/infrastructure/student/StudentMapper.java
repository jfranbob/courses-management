package com.jfranbob.coursesmanagement.infrastructure.student;

import com.jfranbob.coursesmanagement.domain.student.Student;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StudentMapper {
    StudentEntity toEntity(Student student);

    Student toDomain(StudentEntity entity);
}

