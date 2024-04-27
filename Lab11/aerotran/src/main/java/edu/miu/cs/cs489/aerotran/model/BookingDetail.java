package edu.miu.cs.cs489.aerotran.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class BookingDetail {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long bookingId;

    private String seatNumber;
    private String status;


    @ManyToOne
    @JoinColumn(name = "passengerId")
    private Passenger passengerId;

    @ManyToOne
    @JoinColumn(name = "flightId")
    private Flight flight;


    public BookingDetail(String seatNumber, String status, Passenger passengerId,Flight flight) {
        this.seatNumber = seatNumber;
        this.status = status;
        this.passengerId = passengerId;
        this.flight = flight;
    }
}
