package com.example.healthfitnessclub.repository;

import com.example.healthfitnessclub.DAO.Routine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoutineRepository extends JpaRepository<Routine, Integer> {
}
