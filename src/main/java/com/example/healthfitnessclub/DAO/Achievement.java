package com.example.healthfitnessclub.DAO;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name="achievement")
@NoArgsConstructor
@Data
public class Achievement {
    @EmbeddedId
    private MemberExerciseCompositeID id;
    @Column(name="reps")
    private int reps;
    @Column(name="weight")
    private int weight;
    @Column(name="duration")
    private int duration;
}
