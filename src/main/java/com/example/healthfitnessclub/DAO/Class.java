package com.example.healthfitnessclub.DAO;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name="classes")
@NoArgsConstructor
@Data
public class Class {
    @Id
    @Column(name="class_id")
    private int id;
    @Column(name="name")
    private String name;

//    @ManyToMany
//    @JoinTable(
//            name = "enrollment",
//            joinColumns = @JoinColumn(name="class_id"),
//            inverseJoinColumns = @JoinColumn(name="member_id")
//    )
//    private List<Member> students;
//
//    @OneToMany
//    @JoinColumn(name="class_id")
//    private List<ClassTime> classTime;
//
//    @ManyToMany
//    @JoinTable(
//            name = "teach",
//            joinColumns = @JoinColumn(name="class_id"),
//            inverseJoinColumns = @JoinColumn(name="trainer_id")
//    )
//    //List of all trainers who teaches this class
//    private List<Trainer> trainers;
}
