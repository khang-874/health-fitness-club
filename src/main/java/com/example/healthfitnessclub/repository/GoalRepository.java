package com.example.healthfitnessclub.repository;

import com.example.healthfitnessclub.DAO.Goal;
import com.example.healthfitnessclub.DAO.MemberExerciseCompositeID;
import com.example.healthfitnessclub.response.AchievementExercise;
import com.example.healthfitnessclub.response.GoalResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GoalRepository extends JpaRepository<Goal, MemberExerciseCompositeID> {

    @Query(value = "SELECT " +
            "e.name AS name" +
            ", e.difficulty AS difficulty" +
            ", g.reps AS reps" +
            ", g.weight AS weight" +
            ", g.duration AS duration " +
            "FROM exercises AS e JOIN goal AS g ON e.exercise_id = g.exercise_id " +
            "WHERE g.member_id = :member_id"
            , nativeQuery = true)
    List<GoalResponse> getAllGoalByMemberID(@Param(value = "member_id") int memberID);


}
