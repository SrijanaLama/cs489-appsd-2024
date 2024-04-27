package edu.miu.cs.cs489.aerotran.model;

import jakarta.persistence.*;
import lombok.*;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString
public class Passenger {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long passengerId;


    @NotBlank(message = "FirstName is Required")
    @Column(nullable = false)
    private String firstName;

    @NotBlank(message = "LastName is Required")
    @Column(nullable = false)
    private String lastName;

    private LocalDate dateOfBirth;

    private String passengerStatus;

//    private String userName;
//
//    private String email;
//
//    private String phoneNumber;

    @OneToOne
    @JoinColumn(columnDefinition = "userId",referencedColumnName = "userId")
    private  User user;



    public Passenger(String firstName, String lastName, LocalDate dateOfBirth, String passengerStatus) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.passengerStatus = passengerStatus;
    }

    public Passenger(String firstName, String lastName, LocalDate dateOfBirth, String passengerStatus, String userName, String email, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.passengerStatus = passengerStatus;
//        this.userName = userName;
//        this.email = email;
//        this.phoneNumber = phoneNumber;
    }

    public void copy(String firstName, String lastName, LocalDate dateOfBirth, String passengerStatus, String userName, String email, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.passengerStatus = passengerStatus;
//        this.userName = userName;
//        this.email = email;
//        this.phoneNumber = phoneNumber;
    }


}
