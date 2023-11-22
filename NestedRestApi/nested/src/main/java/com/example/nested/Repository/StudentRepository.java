package com.example.nested.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.nested.Entity.Student;

@Repository
public interface StudentRepository extends CrudRepository<Student,Integer> {

    
} 
