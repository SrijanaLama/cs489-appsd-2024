package edu.miu.cs.cs489.aerotran.service.impl;

import edu.miu.cs.cs489.aerotran.dto.FlightDto;
import edu.miu.cs.cs489.aerotran.mapper.FlightMapper;
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

    @Autowired
    private FlightMapper flightMapper;

    @Override
    public void saveFlight(FlightDto flightDto) throws Exception {
        Flight flight = flightMapper.convertDtoToEntity(flightDto);
        flightRepository.save(flight);
    }

    @Override
    public Flight getFlightsById(Long flightNumber) {
        return flightRepository.findByFlightId(flightNumber).orElse(null);
    }

    @Override
    public void updateFlight(Long flightId,FlightDto flightDto) throws Exception {
        Flight nFlight = flightMapper.convertDtoToEntity(flightDto);
        Flight oldFlight = flightRepository.findByFlightId(flightId)
                .orElseThrow(()-> new RuntimeException("Flight Not Found"));
        oldFlight.copy(nFlight.getFlightNumber(),nFlight.getAirline(),
                nFlight.getAirCraftType(),nFlight.getOrigin(),nFlight.getDestination(),
                nFlight.getDepartureDateTime(),nFlight.getArrivalDateTime());

        oldFlight.getFareDetails().stream()
                .forEach(fD -> {
                    if (nFlight.getFareDetails().contains(fD)) {


                       fD.setFare(nFlight.getFareDetails().stream()
                               .filter(nFareDetail -> nFareDetail.getSeatType().equals(fD.getSeatType()))
                               .findFirst().get().getFare());
                    }
                });
        flightRepository.save(oldFlight);
    }

    @Override
    public void deleteFlightByFlightId(Long flightId) {
        flightRepository.deleteById(flightId);
    }

    @Override
    public List<Flight> getAllFlights() {
        return flightRepository.findAll();
    }
}
