package edu.miu.cs.cs489.aerotran.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class FlightDetails {

    @Id
    private String flightDetailsId;
    private String fair;
    private String duration;
    private String availableSeats;


}
