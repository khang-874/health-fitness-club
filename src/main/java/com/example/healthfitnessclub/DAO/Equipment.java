package com.example.healthfitnessclub.DAO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="equipments")
@NoArgsConstructor
@Data
public class Equipment {
    @Id
    @Column(name="equipment_id")
    private int id;
    @Column(name="name")
    private String name;
    @Column(name="quantity")
    private int quantity;
}
