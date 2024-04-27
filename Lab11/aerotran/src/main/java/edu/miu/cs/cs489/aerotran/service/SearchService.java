package edu.miu.cs.cs489.aerotran.service;

import edu.miu.cs.cs489.aerotran.dto.FlightDto;
import edu.miu.cs.cs489.aerotran.model.Flight;

import java.time.LocalDateTime;
import java.util.List;

public interface SearchService {

    List<Flight> searchFlight(Long from, Long to, LocalDateTime departureDateTime);
}
