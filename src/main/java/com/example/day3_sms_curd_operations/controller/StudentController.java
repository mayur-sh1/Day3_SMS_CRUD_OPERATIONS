package com.example.day3_sms_curd_operations.controller;

import com.example.day3_sms_curd_operations.dto.StudentRequestDto;
import com.example.day3_sms_curd_operations.dto.StudentResponseDto;
import com.example.day3_sms_curd_operations.model.studentModel;
import com.example.day3_sms_curd_operations.service.studentService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final studentService service;

    public StudentController(studentService service) {
        this.service = service;
    }

    @PostMapping
    public StudentResponseDto addStudent(
            @Valid @RequestBody StudentRequestDto dto
    ) {
        return service.addStudent(dto);
    }



    @GetMapping
    public List<StudentResponseDto> getStudents() {
        return service.getAllStudents();
    }

    @PutMapping("/{id}")
    public StudentResponseDto updateStudent(
            @PathVariable String id,
            @Valid @RequestBody StudentRequestDto dto
    ) {
        return service.updateStudent(id, dto);
    }

    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable String id) {
        service.deleteStudent(id);
        return "Student deleted successfully";
    }
}
