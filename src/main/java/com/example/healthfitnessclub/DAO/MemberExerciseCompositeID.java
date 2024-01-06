package com.example.healthfitnessclub.DAO;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;
import java.util.Objects;

@NoArgsConstructor
@Data
@Embeddable
@AllArgsConstructor
public class MemberExerciseCompositeID implements Serializable {
    @Column(name="member_id")
    private int memberID;
    @Column(name="exercise_id")
    private int exerciseID;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MemberExerciseCompositeID that = (MemberExerciseCompositeID) o;
        return memberID == that.memberID && exerciseID == that.exerciseID;
    }

    @Override
    public int hashCode() {
        return Objects.hash(memberID, exerciseID);
    }
}
