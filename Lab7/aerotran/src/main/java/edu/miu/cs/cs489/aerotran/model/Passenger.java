package edu.miu.cs.cs489.aerotran.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EqualsAndHashCode(callSuper=false)
@ToString
public class Passenger  extends  Role{


    private String passengerId;
    private String passengerStatus;
//    @OneToMany
//    private List<BookingDetails> bookingDetails;


    public Passenger(Long userId, String userName, String password, String email, String phoneNumber, String passengerId, String passengerStatus) {
       // super(userId, userName, password, email, phoneNumber);
        this.passengerId = passengerId;
        this.passengerStatus = passengerStatus;
    }
}
