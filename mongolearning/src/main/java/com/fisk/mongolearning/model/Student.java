package com.fisk.mongolearning.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalTime;
import java.util.List;

@Data
@Document
public class Student {

    @Id
    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private Gender gender;
    private Address address;
    private LocalTime createdAt;
    private List<String> subjects;
    private BigDecimal totalSpentOnBooks;

    public Student(String firstName, String lastName,
                   String email,
                   Gender gender,
                   Address address,
                   LocalTime createdAt,
                   List<String> subjects,
                   BigDecimal totalSpentOnBooks) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.gender = gender;
        this.address = address;
        this.createdAt = createdAt;
        this.subjects = subjects;
        this.totalSpentOnBooks = totalSpentOnBooks;
    }
}
