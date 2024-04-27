package edu.miu.cs.cs489.aerotran.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    @NotBlank(message = "UserName cannot be blank")
    @Column(unique = true)
    private String userName;
    private String password;

    @NotBlank(message = "Email cannot be blank")
    @Email(message = "Invalid email format")
    @Column(unique = true)
    private String email;

    @Size(min = 10, max = 15, message = "Phone number must be between 10 and 15 characters")
    @Pattern(regexp = "\\d{10,15}", message = "Phone number must contain only digits and be between 10 and 15 characters")
    @Column
    private String phoneNumber;


    @OneToMany( mappedBy = "user",cascade = CascadeType.ALL, fetch = FetchType.EAGER,orphanRemoval = true)
    //@JsonManagedReference
    private List<UserRole> userRoles = new ArrayList<>();

    public User(String userName, String password, String email, String phoneNumber) {
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public User(String userName, String password, String email, String phoneNumber, List<UserRole> userRoles) {
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.userRoles = userRoles;
    }

    public User(Long userId, String userName, String password, String email, String phoneNumber) {
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", userRoles=" + userRoles +
                '}';
    }

    public  void copy(String userName,String email,String phoneNumber){
        this.userName = userName;
        this.email = email;
        this.phoneNumber = phoneNumber;

    }

}
