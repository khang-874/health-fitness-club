package com.example.healthfitnessclub.DAO;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalTime;

@Entity
@Table(name = "has_session")
@NoArgsConstructor
@Data
@AllArgsConstructor
public class Session {
    @EmbeddedId
    TrainerMemberCompositeID id;
    @Column(name = "note")
    String note;
    @Column(name = "day")
    LocalTime day;
}

