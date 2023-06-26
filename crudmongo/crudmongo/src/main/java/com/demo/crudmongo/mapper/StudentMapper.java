package com.demo.crudmongo.mapper;

import com.demo.crudmongo.dto.StudentDto;
import com.demo.crudmongo.model.Student;

public class StudentMapper {


    // Convert User JPA Entity into UserDto
    public static StudentDto mapToUserDto(Student student) {
        StudentDto studentDto = new StudentDto(student.getStandard(), student.getName());
        return studentDto;
    }

    // Convert UserDto into User JPA Entity
    public static Student mapToUser(StudentDto studentDto) {
        Student student = new Student(studentDto.getName(), studentDto.getStandard(), null);
        return student;
    }
}

