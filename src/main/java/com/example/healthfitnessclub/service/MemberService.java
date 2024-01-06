package com.example.healthfitnessclub.service;

import com.example.healthfitnessclub.DAO.Achievement;
import com.example.healthfitnessclub.DAO.Class;
import com.example.healthfitnessclub.DAO.Goal;
import com.example.healthfitnessclub.DAO.Member;
import com.example.healthfitnessclub.repository.ClassRepository;
import com.example.healthfitnessclub.repository.MemberRepository;
import com.example.healthfitnessclub.response.AchievementExercise;
import com.example.healthfitnessclub.response.GoalResponse;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class MemberService {
    @Autowired
    MemberRepository memberRepository;
    @Autowired
    ClassService classService;
    @Autowired
    AchievementService achievementService;
    @Autowired
    GoalService goalService;
    public List<Member> getAllMember(){
        return memberRepository.findAll();
    }

    public Optional<Member> getMemberByMemberID(int memberID) {
        return memberRepository.findById(memberID);
    }

    public void createNewMember(Member member) {
        memberRepository.save(member);
    }

    public void deleteByMemberID(int memberID) {
        memberRepository.deleteById(memberID);
    }

    public void deleteByUsername(String username) {
        memberRepository.deleteByUsername(username);
    }
    public List<Class> getAllClassByMemberID(int memberID){
       return classService.getAllClassByMemberID(memberID);
    }

    public List<AchievementExercise> getAllAchievement(int memberID){
        return achievementService.findAllByMemberId(memberID);
    }

    public List<GoalResponse> getAllGoal(int memberID) {
        return goalService.getAllGoalByMemberID(memberID);
    }
}
