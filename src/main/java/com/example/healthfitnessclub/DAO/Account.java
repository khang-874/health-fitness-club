package com.example.healthfitnessclub.DAO;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name="account")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Account {
    @Id
    @Column(name="username")
    private String username;
    @Column(name="password")
    private String password;
    @Column(name="firstname")
    private String firstName;
    @Column(name="lastname")
    private String lastName;
    @OneToMany
    @JoinColumn(name = "username")
    //All role of this account
    private List<Role> roles;
}
