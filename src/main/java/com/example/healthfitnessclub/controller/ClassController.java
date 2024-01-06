package com.example.healthfitnessclub.controller;

import com.example.healthfitnessclub.DAO.Class;
import com.example.healthfitnessclub.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/class")
public class ClassController {
    @Autowired
    ClassService classService;
    @GetMapping("/")
    public List<Class> getAllClass(){
        return classService.getAllClasses();
    }

    @GetMapping("/byClassID")
    public ResponseEntity<Class> getClassByClassId(@RequestParam("classID") int classID){
        Optional<Class> aClass = classService.getClassById(classID);
        return aClass.map(ResponseEntity::ok).orElse(ResponseEntity.badRequest().build());
    }

    @GetMapping("/delete")
    public ResponseEntity<Object> deleteClassByClassID(@RequestParam("classID") int classID) {
        classService.deleteClassById(classID);
        return ResponseEntity.ok("Delete class by classID: " + classID);
    }

    @PostMapping("/")
    public ResponseEntity<Object> createNewClassByClassID(@RequestBody Class aClass){
        classService.createNewClass(aClass);
        return ResponseEntity.ok("Create new class successfully!");
    }


}
