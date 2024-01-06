package com.example.healthfitnessclub.DAO;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name="exercises")
@NoArgsConstructor
@Data
public class Exercise {
    @Id
    @Column(name="exercise_id")
    private int id;
    @Column(name="name")
    private String name;
    @Column(name="difficulty")
    private int difficulty;

//    @ManyToMany
//    @JoinTable(
//            name = "routine_has_exercise",
//            joinColumns = @JoinColumn(name="exercise_id"),
//            inverseJoinColumns = @JoinColumn(name="routine_id")
//    )
//    //List of the routine that this exercise belonged to
//    private List<Routine> routines;
}
