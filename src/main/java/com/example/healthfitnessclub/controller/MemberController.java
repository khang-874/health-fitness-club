package com.example.healthfitnessclub.controller;

import com.example.healthfitnessclub.DAO.Class;
import com.example.healthfitnessclub.DAO.Goal;
import com.example.healthfitnessclub.DAO.Member;
import com.example.healthfitnessclub.response.AchievementExercise;
import com.example.healthfitnessclub.response.GoalResponse;
import com.example.healthfitnessclub.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/members")
public class MemberController {
    @Autowired
    MemberService memberService;
    @GetMapping("/")
    public List<Member> getAllMember(){
        return memberService.getAllMember();
    }
    @GetMapping("/byMemberID")
    public ResponseEntity<Member> getMemberByMemberID(@RequestParam("memberID") int memberID){
        Optional<Member> member = memberService.getMemberByMemberID(memberID);
        return member.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.badRequest().build());
    }
    @GetMapping("/classes")
    public List<Class> getAllClassByMemberID(@RequestParam("memberID") int memberID){
        return memberService.getAllClassByMemberID(memberID);
    }
    @GetMapping("/achievements")
    public List<AchievementExercise> getAllAchievementByMemberID(@RequestParam("memberID") int memberID){
        return memberService.getAllAchievement(memberID);
    }
    @GetMapping("/goal")
    public List<GoalResponse> getAllGoalByMemberID(@RequestParam("memberID") int memberID){
        return memberService.getAllGoal(memberID);
    }
    @PostMapping("/")
    public ResponseEntity<Object> createNewMember(@RequestBody Member member){
        memberService.createNewMember(member);
        return ResponseEntity.ok("Create member successfully");
    }
    @GetMapping(value = "/delete", params = "memberID")
    public ResponseEntity<Object> deleteMemberByMemberID(@RequestParam(value = "memberID") int memberID){
        memberService.deleteByMemberID(memberID);
        return ResponseEntity.ok("Delete member with memberID: " + memberID);
    }
    @GetMapping(value = "/delete", params = "username")
    public ResponseEntity<Object> deleteMemberByUsername(@RequestParam(value = "username") String username){
        memberService.deleteByUsername(username);
        return ResponseEntity.ok("Delete member with username: " + username);
    }

}
