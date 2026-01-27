package com.example.day3_sms_curd_operations.controller;

import com.example.day3_sms_curd_operations.model.studentModel;
import com.example.day3_sms_curd_operations.service.studentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/students")
    public List<studentModel> getStudents(){
        return service.getStudents();
    }

    @PutMapping("/update/{id}")
    public studentModel updateStudent(@PathVariable String id,@RequestBody studentModel student){
        return  service.updateStudent(id,student);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteStudent(@PathVariable String id) {
        service.deleteStudent(id);
        return "Student with ID " + id + " deleted successfully";
    }
}
