package com.example.healthfitnessclub.DAO;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Table(name="goal")
@Data
public class Goal {
    @EmbeddedId
    private MemberExerciseCompositeID id;
    @Column(name="reps")
    private int reps;
    @Column(name="weight")
    private int weight;
    @Column(name="duration")
    private int duration;
}
