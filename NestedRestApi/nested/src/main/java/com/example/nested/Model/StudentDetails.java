package com.example.nested.Model;


import jakarta.persistence.Embeddable;

import lombok.Getter;
import lombok.Setter;


@Embeddable
@Getter
@Setter
public class StudentDetails {

    
    private String fatherName;
    private int fatherAge;
    private String brotherName;
    private int brotherAge;


    
}
