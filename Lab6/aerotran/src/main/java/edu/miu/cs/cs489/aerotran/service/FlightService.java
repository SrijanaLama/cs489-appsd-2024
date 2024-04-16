package edu.miu.cs.cs489.aerotran.service;

import edu.miu.cs.cs489.aerotran.dto.FlightDto;
import edu.miu.cs.cs489.aerotran.model.Flight;

import java.util.List;

public interface FlightService {

    void saveFlight(FlightDto flightDto) throws Exception;

    Flight getFlightsById(Long flightNumber);

    void updateFlight(Flight flight);

    void deleteFlightByFlightId(Long flightId);

    List<Flight> getAllFlights( );


}
