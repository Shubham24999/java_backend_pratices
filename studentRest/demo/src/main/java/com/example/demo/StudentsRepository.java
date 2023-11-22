package com.example.demo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface StudentsRepository extends CrudRepository<StudentsEntity,Integer>{
    
}
