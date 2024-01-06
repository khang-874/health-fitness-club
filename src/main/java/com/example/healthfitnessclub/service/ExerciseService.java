package com.example.healthfitnessclub.service;

import com.example.healthfitnessclub.DAO.Exercise;
import com.example.healthfitnessclub.repository.ExerciseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExerciseService {
    @Autowired
    ExerciseRepository exerciseRepository;
    public List<Exercise> getAllExercise(){
        return exerciseRepository.findAll();
    }
    public Optional<Exercise> getExerciseByExerciseID(int exerciseID){
        return exerciseRepository.findById(exerciseID);
    }

    public void createNewExercise(Exercise exercise){
        exerciseRepository.save(exercise);
    }
    public void deleteExerciseByExerciseID(int exerciseID){
        exerciseRepository.deleteById(exerciseID);
    }
}
