package edu.miu.cs.cs489.aerotran.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
//@ToString
public class UserRole {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userRoleId;

    @ManyToOne
    @JoinColumn(name = "userId")
    @JsonBackReference

    private User user;

    @ManyToOne
    @JoinColumn(name = "roleId")
    @JsonBackReference

    private Role role;

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
}
