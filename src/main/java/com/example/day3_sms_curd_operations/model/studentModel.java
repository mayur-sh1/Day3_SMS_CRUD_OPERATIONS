package com.example.day3_sms_curd_operations.model;

import com.mongodb.internal.connection.Connection;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Document(collection = "student_SMS") // this dependencies is for mongoDB
public class studentModel {

    @Id
    private String id;

    private String name;
    private int age;
    private String email;
}
