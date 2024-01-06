package com.example.healthfitnessclub.service;

import com.example.healthfitnessclub.DAO.Achievement;
import com.example.healthfitnessclub.DAO.Member;
import com.example.healthfitnessclub.DAO.MemberExerciseCompositeID;
import com.example.healthfitnessclub.repository.AchievementRepository;
import com.example.healthfitnessclub.response.AchievementExercise;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Service
@NoArgsConstructor
@AllArgsConstructor
public class AchievementService {
    @Autowired
    private AchievementRepository achievementRepository;
    public List<AchievementExercise> findAllByMemberId(int memberID){
        return achievementRepository.findAllByMemberID(memberID);
    }

    public List<Member> findAllMemberByExerciseID(int exerciseID){
        return achievementRepository.findAllMemberByExerciseID(exerciseID);
    }
    public List<Achievement> findAllAchievements(){
        Iterator<Achievement> it = achievementRepository.findAll().iterator();
        List<Achievement> result = new ArrayList<Achievement>();
        while(it.hasNext())
            result.add(it.next());
        return result;
    }
    public String createNewAchievement(Achievement achievement) {
        achievementRepository.save(achievement);
        return "Save achievement successfully";
    }

    public ResponseEntity<Object> deleteByExerciseID(int exerciseID) {
        achievementRepository.deleteByExerciseID(exerciseID);
        return ResponseEntity.ok("Delete all achievement with exerciseID: "  + exerciseID);
    }
    public ResponseEntity<Object> deleteByMemberID(int memberID){
        achievementRepository.deleteByMemberID(memberID);
        return ResponseEntity.ok("Delete all achievement with memberID: " + memberID);
    }
    public ResponseEntity<Object> deleteByMemberIDAndExerciseID(int exerciseID, int memberID){
        achievementRepository.deleteById(new MemberExerciseCompositeID(memberID, exerciseID));
        return ResponseEntity.ok("Delete achievement with memberID: " + memberID + " and exerciseID: " + exerciseID);
    }
}
