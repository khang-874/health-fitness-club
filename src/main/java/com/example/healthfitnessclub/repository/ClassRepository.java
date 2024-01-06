package com.example.healthfitnessclub.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.healthfitnessclub.DAO.Class;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClassRepository extends JpaRepository<Class, Integer> {
    @Query(value="SELECT c.* FROM classes AS c JOIN enrollment AS e ON c.class_id = e.class_id WHERE e.member_id = :memberID", nativeQuery = true)
    List<Class> findAllClassByMemberID(@Param(value = "memberID") int memberID);
}
