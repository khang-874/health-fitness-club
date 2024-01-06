package com.example.healthfitnessclub.DAO;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.sql.Time;
import java.util.Objects;

@Entity
@NoArgsConstructor
@Data
@Table(name="class_time")
public class ClassTime {
    @EmbeddedId
    private ClassTimeID classTimeID;
}

@Embeddable
class ClassTimeID implements Serializable {
    @Column(name="class_id", nullable = false, unique = true)
    private int id;
    @Column(name="day", nullable = false, unique = true)
    private int day;
    @Column(name="time", nullable = false, unique = true)
    private Time time;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClassTimeID that = (ClassTimeID) o;
        return id == that.id && day == that.day && Objects.equals(time, that.time);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, day, time);
    }
}

