package com.example.day3_sms_curd_operations.service;

import com.example.day3_sms_curd_operations.model.studentModel;
import com.example.day3_sms_curd_operations.repository.studentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

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

    // display students
    public List<studentModel> getStudents(){
        return repository.findAll();
    }

    // update student
    public studentModel updateStudent(String id,studentModel student){
       studentModel existingStudent =repository.findById(id)
        .orElseThrow(()->new RuntimeException("No Student Found"));

       existingStudent.setName(student.getName());
       existingStudent.setAge(student.getAge());
       existingStudent.setEmail(student.getEmail());

       return repository.save(existingStudent);
    }
    // delete student
    public void deleteStudent(String id) {
        repository.deleteById(id);
    }

}
