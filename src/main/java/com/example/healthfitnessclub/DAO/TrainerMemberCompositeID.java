package com.example.healthfitnessclub.DAO;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Embeddable
@Data
@AllArgsConstructor
public class TrainerMemberCompositeID implements Serializable {
    @Column(name = "trainer_id")
    private int trainer_id;
    @Column(name = "member_id")
    private int member_id;
}
