package edu.miu.cs.cs489.aerotran.model;

import edu.miu.cs.cs489.aerotran.model.lookup.AircraftType;
import edu.miu.cs.cs489.aerotran.model.lookup.Airline;
import edu.miu.cs.cs489.aerotran.model.lookup.Airport;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long flightId;

    @Column(unique = true)
    private String flightNumber;

    @ManyToOne
    @JoinColumn(name = "airlineId", referencedColumnName = "airlineId")
    private Airline airline;

    @ManyToOne
    @JoinColumn(name = "aircraftTypeId", referencedColumnName = "aircraftTypeId")
    private AircraftType airCraftType;


    @ManyToOne
    @JoinColumn(name = "originAirportId", referencedColumnName = "airportId")
    private Airport origin;

    @ManyToOne
    @JoinColumn(name = "destinationAirportId", referencedColumnName = "airportId")
    private Airport destination;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name="flightId")
    private List<FareDetails> fareDetails;

    private LocalDateTime departureDateTime;

    private LocalDateTime arrivalDateTime;


    public Flight(String flightNumber, LocalDateTime departureDateTime, LocalDateTime arrivalDateTime) {
        this.flightNumber = flightNumber;
        this.departureDateTime = departureDateTime;
        this.arrivalDateTime = arrivalDateTime;
    }

    public void copy(String flightNumber, Airline airline, AircraftType airCraftType, Airport origin, Airport destination, LocalDateTime departureDateTime, LocalDateTime arrivalDateTime) {
        this.flightNumber = flightNumber;
        this.airline = airline;
        this.airCraftType = airCraftType;
        this.origin = origin;
        this.destination = destination;
      //  this.fareDetails = fareDetails;
        this.departureDateTime = departureDateTime;
        this.arrivalDateTime = arrivalDateTime;
    }
}
