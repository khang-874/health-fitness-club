package com.example.healthfitnessclub.DAO;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Entity
@Table(name="routines")
@NoArgsConstructor
@Data
public class Routine {
    @Id
    @Column(name="routine_id")
    private int id;
    @Column(name="name")
    private String name;
//    @ManyToMany
//    @JoinTable(
//            name = "routine_has_exercise",
//            joinColumns = @JoinColumn(name="routine_id"),
//            inverseJoinColumns = @JoinColumn(name="exercise_id")
//    )
//    private List<Exercise> exercises;
//
//    @ManyToMany(mappedBy = "routines")
//    //List of all member having this routine
//    private List<Member> members;
}
