package edu.miu.cs.cs489.aerotran.dto;

import java.time.LocalDateTime;
import java.util.List;

public record FlightDto(String flightNumber, Long airlineId,
                        Long airCraftTypeId,
                        Long airportOriginId, Long airportDestinationId,
                        List<FareDetailsDto> fareDetailsDto,
                        LocalDateTime departureDateTime,
                        LocalDateTime arrivalDateTime,

                        String airportOrigin,

                        String airportDestination,

                        String airline,

                        String aircraftType,

                        String aircraftDescription

                        ) {

    public FlightDto(String flightNumber, Long airlineId, Long airCraftTypeId, Long airportOriginId, Long airportDestinationId, List<FareDetailsDto> fareDetailsDto, LocalDateTime departureDateTime, LocalDateTime arrivalDateTime) {
        this(flightNumber, airlineId, airCraftTypeId, airportOriginId, airportDestinationId, fareDetailsDto, departureDateTime, arrivalDateTime, null, null, null, null, null);
    }
}
