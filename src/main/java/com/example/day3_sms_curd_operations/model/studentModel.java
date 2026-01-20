package com.example.day3_sms_curd_operations.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "SMS") // this dependencies is for mongoDB
public class studentModel {

    @Id // annotator to identify primary key
    private String id;

    private String name;
    private int age;
    private String email;
}
