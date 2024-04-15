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
public class Flight {

    @Id
    private Long flightId;
    private String flightNumber;
    @OneToOne
    private Airline airline;
    private String airCraftType;
    private String capacity;
    @OneToOne
    private Airport origin;
    @OneToOne
    private Airport destination;
    @OneToOne
    private FlightDetail flightDetails;
    @OneToOne
    private FlightSchedule flightSchedules;





}
