package edu.miu.cs.cs489.aerotran.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "dtype", discriminatorType = DiscriminatorType.STRING)
public class User {

    @Id
    private Long userId;
    private String userName;
    private String password;
    private String email;
    private String phoneNumber;

//    @OneToMany
//    private List<Role> roles;

//    public User(Long userId, String userName, String password, String email, String phoneNumber) {
//        this.userId = userId;
//        this.userName = userName;
//        this.password = password;
//        this.email = email;
//        this.phoneNumber = phoneNumber;
//    }


}
