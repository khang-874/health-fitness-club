package com.example.healthfitnessclub.service;

import com.example.healthfitnessclub.DAO.Class;
import com.example.healthfitnessclub.repository.ClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClassService {
    @Autowired
    ClassRepository classRepository;
    public List<Class> getAllClasses(){
        return classRepository.findAll();
    }
    public Optional<Class> getClassById(int id){
        return classRepository.findById(id);
    }
    public void deleteClassById(int id){
        classRepository.deleteById(id);
    }
    public void createNewClass(Class aClass){
        classRepository.save(aClass);
    }
    public List<Class> getAllClassByMemberID(int memberID){
        return classRepository.findAllClassByMemberID(memberID);
    }
}
