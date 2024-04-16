package edu.miu.cs.cs489.aerotran.mapper;

import edu.miu.cs.cs489.aerotran.dto.FlightDto;
import edu.miu.cs.cs489.aerotran.model.FareDetails;
import edu.miu.cs.cs489.aerotran.model.Flight;
import edu.miu.cs.cs489.aerotran.model.lookup.AircraftType;
import edu.miu.cs.cs489.aerotran.model.lookup.Airline;
import edu.miu.cs.cs489.aerotran.repository.lookup.AircraftTypeRepository;
import edu.miu.cs.cs489.aerotran.repository.lookup.AirlineRepository;
import edu.miu.cs.cs489.aerotran.repository.lookup.AirportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.stream.Collectors;


@Component
public class FlightMapper {

    @Autowired
    private AircraftTypeRepository aircraftTypeRepository;

    @Autowired
    private AirlineRepository airlineRepository;

    @Autowired
    private AirportRepository airportRepository;

    public  Flight convertDtoToEntity(FlightDto flightDto) throws  Exception{
        return Optional.ofNullable(flightDto)
                .map(dto ->{
                    Flight flight = new Flight(dto.flightNumber(),dto.departureDateTime(),flightDto.arrivalDateTime());
                    flight.setAirline(airlineRepository.getReferenceById(dto.airlineId()));
                    flight.setDestination(airportRepository.getReferenceById(dto.airportDestinationId()));
                    flight.setOrigin(airportRepository.getReferenceById(dto.airportDestinationId()));
                    flight.setAirCraftType(aircraftTypeRepository.getReferenceById(dto.airCraftTypeId()));
                    flight.setFareDetails(dto.fairDetailsDto().stream().map(f->{
                        return new FareDetails(f.fair(),f.seatType());
                    }).collect(Collectors.toList()));
                    return flight;

                }).orElse(null);

    }
}
