package com.example.healthfitnessclub.DAO;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name="trainers")
@NoArgsConstructor
@Data
public class Trainer {
    @Id
    @Column(name="trainer_id")
    private int id;
    @OneToOne
    @JoinColumn(name="username")
    private Account account;

//    @ManyToMany
//    @JoinTable(
//            name="teach",
//            joinColumns = @JoinColumn(name="trainer_id"),
//            inverseJoinColumns = @JoinColumn(name="class_id")
//    )
//    //List of classes being taught by this trainer
//    private List<Class> classes;
}
