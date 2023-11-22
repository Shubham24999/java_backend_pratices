package com.example.nested.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.nested.Entity.Student;
import com.example.nested.Repository.StudentRepository;

@Service
public class StudentService {
    
    @Autowired
    StudentRepository studentRepository;

    public List<Student> getAllStudentData(){

        return (List<Student>) studentRepository.findAll();
    }

    public Optional<Student> getSingleStudent(Integer id){
        return studentRepository.findById(id);
    }
    
    public Student setSingleStudentData(Student data){

        return studentRepository.save(data);
    }

    

    public Optional<Student> updateStudentData(Integer id, Student data){
       
       Optional<Student> isData= studentRepository.findById(id);

       if (isData.isPresent()) {

        Student singleStudent=isData.get();
        
        if (data.getName()!=null) {
            singleStudent.setName(data.getName());
        }
        if (data.getGrade()!=null) {
            singleStudent.setGrade(data.getGrade());
        }
        if (data.getAge()!=null) {
           singleStudent.setAge(data.getAge());
        }
        if (data.getDetails()!=null) {
            singleStudent.setDetails(data.getDetails());
        }

        Student updatedStudent = studentRepository.save(singleStudent);
        return Optional.of(updatedStudent);
        
       }

        return Optional.empty();
    }


    public void deleteStudentData(Integer id){
        studentRepository.deleteById(id);
    }
    
}
