package edu.miu.cs.cs489.aerotran.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User implements UserDetails {



    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;
    private String userName;
    private String password;
    private String email;
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
    public User(Long userId, String userName, String email, String phoneNumber) {
        this.userId = userId;
        this.userName = userName;
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

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        String[] userRoles = getUserRoles().stream()
                .map((role) -> role.getRole().getRoleName())
                .toArray(String[]::new);
        Collection<GrantedAuthority> authorities = AuthorityUtils.
                createAuthorityList(userRoles);
        return authorities;
    }

    @Override
    public String getUsername() {
        return userName;
    }
}
