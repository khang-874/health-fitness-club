package com.example.healthfitnessclub.DAO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name="members")
@NoArgsConstructor
@Data
public class Member {
    @Id
    @Column(name="member_id")
    private int id;
    @Column(name="weight")
    private float weight;
    @Column(name="height")
    private float height;

    @Transient
    public String getFirstName(){
        return account.getFirstName();
    };
    @Transient
    public String getLastName(){
        return account.getLastName();
    }
    @JsonIgnore
    @OneToOne
    @JoinColumn(name="username")
    private Account account;
}
