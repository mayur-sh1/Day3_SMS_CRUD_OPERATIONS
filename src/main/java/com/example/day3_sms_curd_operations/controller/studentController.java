package com.example.day3_sms_curd_operations.controller;

import com.example.day3_sms_curd_operations.model.studentModel;
import com.example.day3_sms_curd_operations.service.studentService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class studentController {
    private final studentService service;

    public studentController(studentService service) {
        this.service = service;
    }
    @PostMapping("add-student/")
    public studentModel addStudent(@RequestBody studentModel student){
        return service.addStudent(student);
    }
}
