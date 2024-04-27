package edu.miu.cs.cs489.aerotran.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.boot.context.properties.bind.DefaultValue;

import java.io.Serializable;
import java.util.Objects;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
//@ToString
public class UserRole implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userRoleId;

    @ManyToOne
    @JoinColumn(name = "userId")
    @JsonBackReference
    private User user;


    @ManyToOne
    @JoinColumn(name = "roleId")
   //@JsonBackReference
    private Role role;

    private String status ="ACTIVE";

    @Override
    public String toString() {
        return "UserRole{" +
                "userRoleId=" + userRoleId +
                ", userId=" + (user != null ? user.getUserId() : null) +
                ", roleId=" + (role != null ? role.getRoleId() : null) +
                '}';
    }

    public UserRole(User user, Role role) {
        this.user = user;
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserRole userRole = (UserRole) o;
        return Objects.equals(user.getUserId(), userRole.user.getUserId()) &&
                Objects.equals(role.getRoleId(), userRole.role.getRoleId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(user, role);
    }
}
