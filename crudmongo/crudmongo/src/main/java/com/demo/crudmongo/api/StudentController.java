package com.demo.crudmongo.api;

import com.demo.crudmongo.dto.StudentDto;
import com.demo.crudmongo.exception.BadMoodException;
import com.demo.crudmongo.exception.ErrorDetails;
import com.demo.crudmongo.exception.StudentNotFoundException;
import com.demo.crudmongo.model.Student;
import com.demo.crudmongo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;
    @GetMapping("/get")
    public List<Student> getAllStud() {
        return studentService.getAll() ;
    }
    @PostMapping("/add")
    public Student add(@RequestBody Student student) {
        return studentService.addstud(student);
    }
    @GetMapping("/get/{id}")
    public Student get(@PathVariable("id") String id) {
        return studentService.getById(id);
    }
    @DeleteMapping("/delete/{id}")
    public String deleteStud(@PathVariable String id){
        studentService.delete(id);
        return "Success";
    }
    @PostMapping("/createUser")
    public ResponseEntity<StudentDto> createUser(@RequestBody StudentDto user){
        StudentDto savedUser = studentService.createUser(user);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }
    @ExceptionHandler(StudentNotFoundException.class)
    public ResponseEntity<ErrorDetails> handleResourceNotFoundException(StudentNotFoundException exception,
                                                                        WebRequest webRequest){
        ErrorDetails errorDetails = new ErrorDetails(
                LocalDateTime.now(),
                exception.getMessage(),
                webRequest.getDescription(false),
                "USER_NOT_FOUND"
        );
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(BadMoodException.class)
    public ResponseEntity<ErrorDetails> BAdMoodException(BadMoodException exception,
                                                                        WebRequest webRequest){
        ErrorDetails errorDetails = new ErrorDetails(
                LocalDateTime.now(),
                exception.getMessage(),
                webRequest.getDescription(false),
                "Bad Mood"
        );
        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
    }



}
