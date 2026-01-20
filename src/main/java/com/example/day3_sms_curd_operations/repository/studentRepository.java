package com.example.day3_sms_curd_operations.repository;

import com.example.day3_sms_curd_operations.model.studentModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface studentRepository extends MongoRepository <studentModel,String> {
    // kaam kregi studentModel k sth and string for id type string hai
}
