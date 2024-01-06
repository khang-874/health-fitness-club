package com.example.healthfitnessclub.repository;

import com.example.healthfitnessclub.DAO.Achievement;
import com.example.healthfitnessclub.DAO.Member;
import com.example.healthfitnessclub.DAO.MemberExerciseCompositeID;
import com.example.healthfitnessclub.response.AchievementExercise;
import org.hibernate.annotations.Parent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface AchievementRepository extends JpaRepository<Achievement, MemberExerciseCompositeID> {
    @Query(value = "SELECT " +
            "e.name AS name" +
            ", e.difficulty AS difficulty" +
            ", a.reps AS reps" +
            ", a.weight AS weight" +
            ", a.duration AS duration " +
            "FROM exercises AS e JOIN achievement AS a ON e.exercise_id = a.exercise_id " +
            "WHERE a.member_id = :member_id"
            , nativeQuery = true)
    List<AchievementExercise> findAllByMemberID(@Param(value = "member_id") int memberID);

    @Query(value="SELECT m.* " +
            "FROM members AS m JOIN achievement as a ON m.member_id = a.member_id " +
            "JOIN account AS acc ON members." +
            "WHERE a.exercise_id = :exercise_id", nativeQuery = true)
    List<Member> findAllMemberByExerciseID(@Param(value="exercise_id") int exerciseID);

    @Modifying
    @Query(value="DELETE FROM achievement WHERE achievement.exercise_id = :exercise_id", nativeQuery = true)
    void deleteByExerciseID(@Param(value="exercise_id") int exerciseID);

    @Modifying
    @Query(value="DELETE FROM achievement WHERE achievement.member_id = :member_id", nativeQuery = true)
    void deleteByMemberID(@Param(value="member_id") int memberID);
}
