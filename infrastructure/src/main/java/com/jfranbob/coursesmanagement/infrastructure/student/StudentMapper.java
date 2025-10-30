package com.jfranbob.coursesmanagement.infrastructure.student;

import com.jfranbob.coursesmanagement.domain.student.Student;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface StudentMapper {
    StudentEntity toEntity(Student student);

    Student toDomain(StudentEntity entity);
}
