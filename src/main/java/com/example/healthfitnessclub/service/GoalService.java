package com.example.healthfitnessclub.service;

import com.example.healthfitnessclub.DAO.Goal;
import com.example.healthfitnessclub.DAO.MemberExerciseCompositeID;
import com.example.healthfitnessclub.repository.GoalRepository;
import com.example.healthfitnessclub.response.GoalResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GoalService {
    @Autowired
    GoalRepository goalRepository;
    public List<Goal> getAllGoal(){
        return goalRepository.findAll();
    }
    public List<GoalResponse> getAllGoalByMemberID(int memberID){
        return goalRepository.getAllGoalByMemberID(memberID);
    }

    public Optional<Goal> getAllGoalByMemberIDAndExerciseID(int memberID, int exerciseID){
        return goalRepository.findById(new MemberExerciseCompositeID(memberID, exerciseID));
    }

    public void createNewGoal(Goal goal){
        goalRepository.save(goal);
    }
    public void deleteGoal(int memberID, int exerciseID){
        goalRepository.deleteById(new MemberExerciseCompositeID(memberID, exerciseID));
    }
}

