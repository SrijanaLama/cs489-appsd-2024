package edu.miu.cs.cs489.aerotran.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString
public class Passenger {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long passengerId;

    private String firstName;

    private String lastName;

    private LocalDate dateOfBirth;

    private String passengerStatus;

    private String userName;

    private String email;

    private String phoneNumber;

    private Long userId;




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
        this.userName = userName;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public void copy(String firstName, String lastName, LocalDate dateOfBirth, String passengerStatus, String userName, String email, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.passengerStatus = passengerStatus;
        this.userName = userName;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }


}
