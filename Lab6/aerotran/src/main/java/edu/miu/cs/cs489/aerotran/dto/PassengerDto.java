package edu.miu.cs.cs489.aerotran.dto;

import java.time.LocalDate;

public record PassengerDto( String passengerId,String firstName,String lastName,
                            LocalDate dateOfBirth, String passengerStatus,   String userName ,String email,String phoneNumber) {

    public PassengerDto(String firstName, String lastName, LocalDate dateOfBirth, String passengerStatus,String userName,String email,String phoneNumber) {
        this(null, firstName, lastName, dateOfBirth, passengerStatus,userName,email,phoneNumber);
    }
}
