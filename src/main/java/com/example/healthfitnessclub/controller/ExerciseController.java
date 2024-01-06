package com.example.healthfitnessclub.controller;

import com.example.healthfitnessclub.DAO.Exercise;
import com.example.healthfitnessclub.service.ExerciseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/exercises")
public class ExerciseController {
    @Autowired
    ExerciseService exerciseService;
    @GetMapping("/")
    public List<Exercise> getAllExercise(){
        return exerciseService.getAllExercise();
    }
    @GetMapping("/byExerciseID")
    public ResponseEntity<Exercise> getExerciseByExerciseID(@RequestParam("exerciseID") int exerciseID){
        Optional<Exercise> exercise = exerciseService.getExerciseByExerciseID(exerciseID);
        return exercise.map(ResponseEntity::ok).orElse(ResponseEntity.badRequest().build());
    }
    @GetMapping("/delete")
    public ResponseEntity<Object> deleteByExerciseID(@RequestParam("exerciseID") int exerciseID){
        exerciseService.deleteExerciseByExerciseID(exerciseID);
        return ResponseEntity.ok("Delete exercise with ID: " + exerciseID);
    }
    @PostMapping("/")
    public ResponseEntity<Object> createNewExercise(@RequestBody Exercise exercise){
        exerciseService.createNewExercise(exercise);
        return ResponseEntity.ok("Create new exercise successfully");
    }
}
