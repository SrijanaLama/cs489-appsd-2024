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
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private Long bookingId;

    private String seatNumber;
    private String status;  //Paid //UnPaid


    @ManyToOne
    @JoinColumn(name = "department_id")
    private Passenger passengerId;


    public BookingDetail(String seatNumber, String status, Passenger passengerId) {
        this.seatNumber = seatNumber;
        this.status = status;
        this.passengerId = passengerId;
    }
}
