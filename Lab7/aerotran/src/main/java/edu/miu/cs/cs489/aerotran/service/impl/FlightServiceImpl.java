package edu.miu.cs.cs489.aerotran.service.impl;

import edu.miu.cs.cs489.aerotran.model.Flight;
import edu.miu.cs.cs489.aerotran.repository.FlightRepository;
import edu.miu.cs.cs489.aerotran.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class FlightServiceImpl implements FlightService {

    @Autowired
    private FlightRepository flightRepository;

    @Override
    public void saveFlight(Flight flight) {
        flightRepository.save(flight);
    }

    @Override
    public Flight getFlightsById(Long flightNumber) {
        return flightRepository.findByFlightId(flightNumber).orElse(null);
    }

    @Override
    public void updateFlight(Flight flight) {
         flightRepository.save(flight);
    }

    @Override
    public void deleteFlightByFlightId(Long flightId) {
        flightRepository.deleteFlightByFlightId(flightId);
    }

    @Override
    public List<Flight> getAllFlights() {
        return flightRepository.findAll();
    }
}
