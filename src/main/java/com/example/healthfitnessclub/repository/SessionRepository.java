package com.example.healthfitnessclub.repository;

import com.example.healthfitnessclub.DAO.Session;
import com.example.healthfitnessclub.DAO.TrainerMemberCompositeID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SessionRepository extends JpaRepository<Session, TrainerMemberCompositeID> {

}
