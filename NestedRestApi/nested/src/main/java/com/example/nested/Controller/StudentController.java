package com.example.nested.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.nested.Entity.Student;
import com.example.nested.Service.StudentService;

@RestController
// @RequestMapping("/students")
public class StudentController {
    
    @Autowired
    StudentService studentService;
    
    @GetMapping("/students")
    public List<Student> getStudents(){
        return studentService.getAllStudentData();
    }
    
    @GetMapping("/student/{id}")
    public Optional<Student> getStudent(@PathVariable Integer id){
        return studentService.getSingleStudent(id);
    }
    
    @PostMapping("/student/create")
    public Student setStudentData(@RequestBody Student studentData){

     return studentService.setSingleStudentData(studentData);
    }


    @PutMapping("/student/update/{id}")
    public Optional<Student> updateData(@PathVariable Integer id, @RequestBody Student data){
        
        return studentService.updateStudentData(id,data);
    }
    
    @DeleteMapping("/student/delete/{id}")
    public void deleteData(@PathVariable Integer id){
         studentService.deleteStudentData(id);
    }
}
