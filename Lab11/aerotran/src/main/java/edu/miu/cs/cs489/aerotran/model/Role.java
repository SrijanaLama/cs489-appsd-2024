package edu.miu.cs.cs489.aerotran.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Role  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long roleId;

    @NotBlank(message = "Role Name is Required")
    @Column(nullable = false,unique = true)
    private String roleName;

    public Role(String roleName) {
        this.roleName = roleName;
    }

    public Role(Long roleId) {
        this.roleId = roleId;
    }
}
