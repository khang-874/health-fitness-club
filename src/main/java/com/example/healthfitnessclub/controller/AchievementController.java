package com.example.healthfitnessclub.controller;

import com.example.healthfitnessclub.DAO.Achievement;
import com.example.healthfitnessclub.DAO.Member;
import com.example.healthfitnessclub.response.AchievementExercise;
import com.example.healthfitnessclub.service.AchievementService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/achievements")
@NoArgsConstructor
public class AchievementController {
    @Autowired
    private AchievementService achievementService;
    @GetMapping("/")
    public List<Achievement> findAllAchievements(){
        return achievementService.findAllAchievements();
    }
    @GetMapping("/byMemberID")
    public List<AchievementExercise> findAllExerciseByMemberID(@RequestParam(value = "memberID") int memberID){
        return achievementService.findAllByMemberId(memberID);
    }

    @GetMapping("/byExerciseID")
    public List<Member> findAllMemberByExerciseID(@RequestParam(value = "exerciseID") int exerciseID){
        return achievementService.findAllMemberByExerciseID(exerciseID);
    }

    @PostMapping("/")
    public ResponseEntity<Object> createNewAchievement(@RequestBody Achievement achievement){
        String response = achievementService.createNewAchievement(achievement);
        return ResponseEntity.ok(response);
    }
    @GetMapping(value = "/delete", params = "exerciseID")
    public ResponseEntity<Object> deleteAchievementByExerciseID(@RequestParam(value="exerciseID") int exerciseID){
        return achievementService.deleteByExerciseID(exerciseID);
    }
    @GetMapping(value = "/delete", params = "memberID")
    public ResponseEntity<Object> deleteAchievementByMemberID(@RequestParam(value="memberID") int memberID){
        return achievementService.deleteByMemberID(memberID);
    }
    @GetMapping("/delete")
    public ResponseEntity<Object> deleteAchievementByMemberIDAndExerciseID(@RequestParam(value="memberID") int memberID, @RequestParam(value="exerciseID") int exerciseID){
        return achievementService.deleteByMemberIDAndExerciseID(exerciseID, memberID);
    }
}



