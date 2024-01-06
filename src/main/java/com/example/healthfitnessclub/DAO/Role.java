package com.example.healthfitnessclub.DAO;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name="roles")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Role{
    @EmbeddedId
    private RoleID roleID;
}

@Embeddable
class RoleID implements Serializable{
    @Column(name="username", unique = true, nullable = false)
    private String username;
    @Column(name="roles", unique = true, nullable = false)
    private String role;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoleID roleID = (RoleID) o;
        return Objects.equals(username, roleID.username) && Objects.equals(role, roleID.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, role);
    }
}
