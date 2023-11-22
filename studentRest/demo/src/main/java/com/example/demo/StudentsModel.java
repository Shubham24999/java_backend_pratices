package com.example.demo;

import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class StudentsModel {
    @Id
    private Integer id;

    private String name;

    private Integer age;

    private Boolean pursuing;
    
}
