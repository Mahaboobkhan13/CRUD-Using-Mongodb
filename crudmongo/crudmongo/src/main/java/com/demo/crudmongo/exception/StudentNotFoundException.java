package com.demo.crudmongo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.function.Supplier;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class StudentNotFoundException extends RuntimeException {

    public StudentNotFoundException(String resourceName, String fieldName, String fieldValue) {
        super(resourceName+" not found with "+fieldName +" :" + fieldValue);


    }}
