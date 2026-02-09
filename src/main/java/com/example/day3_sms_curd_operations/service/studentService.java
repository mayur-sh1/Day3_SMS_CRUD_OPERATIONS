package com.example.day3_sms_curd_operations.service;

import com.example.day3_sms_curd_operations.dto.StudentRequestDto;
import com.example.day3_sms_curd_operations.dto.StudentResponseDto;
import com.example.day3_sms_curd_operations.exception.StudentNotFoundException;
import com.example.day3_sms_curd_operations.model.studentModel;
import com.example.day3_sms_curd_operations.repository.studentRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Service // annotator to represent service
public class studentService {

    private final studentRepository repository;

    public studentService(studentRepository repository) {
        this.repository = repository;
    }

    public StudentResponseDto addStudent(StudentRequestDto dto) {
        studentModel student = new studentModel();
        student.setName(dto.getName());
        student.setAge(dto.getAge());
        student.setEmail(dto.getEmail());

        return map(repository.save(student));
    }

    public List<StudentResponseDto> getAllStudents() {
        return repository.findAll()
                .stream()
                .map(this::map)
                .toList();
    }

    public StudentResponseDto updateStudent(String id, StudentRequestDto dto) {
        studentModel student = repository.findById(id)
                .orElseThrow(() ->
                        new StudentNotFoundException("Student not found with id: " + id)
                );

        student.setName(dto.getName());
        student.setAge(dto.getAge());
        student.setEmail(dto.getEmail());

        return map(repository.save(student));
    }

    public void deleteStudent(String id) {
        if (!repository.existsById(id)) {
            throw new StudentNotFoundException("Student not found with id: " + id);
        }
        repository.deleteById(id);
    }

    private StudentResponseDto map(studentModel s) {
        return new StudentResponseDto(
                s.getId(),
                s.getName(),
                s.getAge(),
                s.getEmail()
        );
    }
}

// services k andr 2 object kyo bnaye jaa rhi h
// 1. for user
// 2 . for database