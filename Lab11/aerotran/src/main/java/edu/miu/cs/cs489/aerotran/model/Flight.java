package edu.miu.cs.cs489.aerotran.model;

import edu.miu.cs.cs489.aerotran.model.lookup.AircraftType;
import edu.miu.cs.cs489.aerotran.model.lookup.Airline;
import edu.miu.cs.cs489.aerotran.model.lookup.Airport;
import jakarta.persistence.*;
import lombok.*;

import javax.validation.constraints.Future;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long flightId;

    @NotBlank(message = "FlightNumber is Required")
    @Column(unique = true,nullable = false)
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



    @Column(nullable = false)
    @NotNull(message = "Departure date and time is required")
    @Future(message = "Departure date and time must be in the future")
    private LocalDateTime departureDateTime;

    @Column(nullable = false)
    @NotNull(message = "Arrival date and time is required")
    @Future(message = "Arrival date and time must be in the future")
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
