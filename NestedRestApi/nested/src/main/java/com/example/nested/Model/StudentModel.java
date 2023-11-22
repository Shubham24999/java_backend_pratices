package com.example.nested.Model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentModel {
    
    private Long id;
    private String name;
    private String grade;
    
    private int age;

    private StudentDetails details;

}
