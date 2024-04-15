package edu.miu.cs.cs489.aerotran.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class BookingDetail {
    @Id
    private String bookingId;

    private String passengerId;
    private String seatNumber;
    private String status;

    @OneToOne
    private Ticket ticket;



}
