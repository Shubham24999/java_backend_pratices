package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentsService {
    
    @Autowired
    StudentsRepository studentsRepository;

    public List<StudentsEntity> getAllStudents(){
        return (List<StudentsEntity>) studentsRepository.findAll();
    }

    public StudentsEntity createStudentData(StudentsModel studentData){

        StudentsEntity studentsEntity=new StudentsEntity();

        studentsEntity.setName(studentData.getName());
        studentsEntity.setAge(studentData.getAge());
        studentsEntity.setPursuing(studentData.getPursuing());


        return studentsRepository.save(studentsEntity);

    }

    public Optional<StudentsEntity> getSingleStudentDataById(Integer id){

        return studentsRepository.findById(id);

    }

    public StudentsEntity updateSingleStudentData(Integer id,StudentsModel modelData){
        
        Optional<StudentsEntity> isStudentDataPresent=studentsRepository.findById(id);

        if(isStudentDataPresent.isPresent()){
            StudentsEntity studentData=isStudentDataPresent.get();
            studentData.setName(modelData.getName());
            studentData.setAge(modelData.getAge());
            studentData.setPursuing(modelData.getPursuing());

            return studentsRepository.save(studentData);
        }
        
        
        return null;
    }
    
    public String deleteSingleStudentData(Integer id){
        studentsRepository.deleteById(id);
        return "Data has been Deleted";
    }
}
