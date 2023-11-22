package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@ResponseBody
@RestController
public class StudentsController {
    
    @Autowired
    StudentsService studentsService;
    
    @GetMapping("/students")
    public List<StudentsEntity> getStudent(){

        return studentsService.getAllStudents();
    }

    @GetMapping("/student/{id}")
    public Optional<StudentsEntity> getSingleStudentById(@PathVariable Integer id ){
        return studentsService.getSingleStudentDataById(id);
    }
    
    @PostMapping("/create")
    public StudentsEntity createStudent(@RequestBody StudentsModel studentData){


        return studentsService.createStudentData(studentData);
    }
    
    @PutMapping("/student/{id}")
    public StudentsEntity updateStudentData(@PathVariable Integer id,@RequestBody StudentsModel modelData){
        
        return studentsService.updateSingleStudentData(id,modelData);
    }

    @DeleteMapping("delete/{id}")
    public String deleteStudentData(@PathVariable Integer id){
        return studentsService.deleteSingleStudentData(id);
    }
    
}
