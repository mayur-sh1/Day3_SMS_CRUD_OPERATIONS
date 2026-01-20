package com.example.day3_sms_curd_operations.service;

import com.example.day3_sms_curd_operations.model.studentModel;
import com.example.day3_sms_curd_operations.repository.studentRepository;
import org.springframework.stereotype.Service;

@Service // annotator to represent service
public class studentService {
    private final studentRepository repository;

    public studentService(studentRepository repository) {
        this.repository = repository;
    }

    // create
    public studentModel addStudent(studentModel student){
        return repository.save(student);
    }
}
