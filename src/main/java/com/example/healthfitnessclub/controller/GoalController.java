package com.example.healthfitnessclub.controller;

import com.example.healthfitnessclub.DAO.Goal;
import com.example.healthfitnessclub.response.GoalResponse;
import com.example.healthfitnessclub.service.GoalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/goals")
public class GoalController {
    @Autowired
    GoalService goalService;
    @GetMapping("/")
    public List<Goal> getAllGoal(){
       return goalService.getAllGoal();
    }
    @GetMapping("/byMemberID")
    public List<GoalResponse> getGoalByMemberID(@Param(value = "memberID") int memberID){
        return goalService.getAllGoalByMemberID(memberID);
    }
    @GetMapping("/byMemberExerciseID")
    public ResponseEntity<Goal> getGoalByMemberIDAndExerciseID(@Param(value="memberID") int memberID, @Param(value="exerciseID") int exerciseID){
        Optional<Goal> goal = goalService.getAllGoalByMemberIDAndExerciseID(memberID, exerciseID);
        return goal.map(ResponseEntity::ok).orElse(ResponseEntity.badRequest().build());
    }
    @PostMapping("/")
    public ResponseEntity<Object> createNewGoal(@RequestBody Goal goal){
        goalService.createNewGoal(goal);
        return ResponseEntity.ok("Create new goal successfully!");
    }
    @GetMapping("/delete")
    public ResponseEntity<Object> deleteGoal(@Param(value="memberID") int memberID, @Param(value="exerciseID") int exerciseID){
        goalService.deleteGoal(memberID, exerciseID);
        return ResponseEntity.ok("Delete a goal with memberID: " + memberID + " and exerciseID: " + exerciseID);
    }
}
