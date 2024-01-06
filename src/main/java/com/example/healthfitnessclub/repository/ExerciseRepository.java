package com.example.healthfitnessclub.repository;

import com.example.healthfitnessclub.DAO.Exercise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExerciseRepository extends JpaRepository<Exercise, Integer> {
}
