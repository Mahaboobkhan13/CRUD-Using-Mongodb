package com.demo.crudmongo.service;

import com.demo.crudmongo.dto.StudentDto;
import com.demo.crudmongo.model.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    public List<Student> getAll();

    public Student addstud(Student student);
    public Student getById(String id);
    public String delete(String id);
    StudentDto createUser(StudentDto user);
}
