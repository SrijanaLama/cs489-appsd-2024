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
public class Ticket {

    @Id
    private Long ticketId;
    private String seatNumber;
    @OneToOne
    private BookingDetail bookingDetails;
    @OneToOne
    private Flight flights;



}
