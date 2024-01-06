package com.example.healthfitnessclub.repository;

import com.example.healthfitnessclub.DAO.MemberExerciseCompositeID;
import com.example.healthfitnessclub.DAO.Administrator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdministratorRepository extends JpaRepository<Administrator, MemberExerciseCompositeID> {

}
