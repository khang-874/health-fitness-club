package com.example.healthfitnessclub.DAO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="administrators")
@NoArgsConstructor
@Data
public class Administrator {
    @Id
    @Column(name="administrator_id")
    private int id;
    @Transient
    public String getFirstName(){
        return account.getFirstName();
    }
    @Transient
    public String getLastName(){
        return account.getLastName();
    }
    @OneToOne
    @JsonIgnore
    @JoinColumn(name="username")
    private Account account;
}
