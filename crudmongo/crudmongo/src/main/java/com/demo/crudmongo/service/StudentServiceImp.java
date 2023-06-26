package com.demo.crudmongo.service;

import com.demo.crudmongo.dto.StudentDto;
import com.demo.crudmongo.exception.BadMoodException;
import com.demo.crudmongo.exception.StudentNotFoundException;
import com.demo.crudmongo.mapper.StudentMapper;
import com.demo.crudmongo.model.Student;
import com.demo.crudmongo.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImp implements StudentService {
    @Autowired
    private StudentRepo studentRepo;

    @Override
    public List<Student> getAll() {
        List<Student> students = Optional.of(studentRepo.findAll()).orElse(null);
        if(students.size()<2){
            throw new BadMoodException("No STudendts am in Bad Mood");}
        return studentRepo.findAll();
    }

    @Override
    public Student addstud(Student student) {
        return studentRepo.save(student);
    }

    @Override
    public Student getById(String id) {
        Student student= studentRepo.findById(id).orElseThrow(
                ()->new StudentNotFoundException("Student","id",id));
     return student;
    }

    @Override
    public String delete(String id) {
        studentRepo.deleteById(id);
        return "";
    }

    @Override
    public StudentDto createUser(StudentDto studentDto) {

        // Convert UserDto into User JPA Entity
        Student user = StudentMapper.mapToUser(studentDto);

        Student savedUser = studentRepo.save(user);

        // Convert User JPA entity to UserDto
        StudentDto savedUserDto = StudentMapper.mapToUserDto(savedUser);

        return savedUserDto;
    }
}
