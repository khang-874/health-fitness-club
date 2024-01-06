package com.example.healthfitnessclub.repository;

import com.example.healthfitnessclub.DAO.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, Integer> {
    @Modifying
    @Query(value = "DELETE FROM members WHERE members.username = :username", nativeQuery = true)
    void deleteByUsername(@Param(value = "username") String username);
}
