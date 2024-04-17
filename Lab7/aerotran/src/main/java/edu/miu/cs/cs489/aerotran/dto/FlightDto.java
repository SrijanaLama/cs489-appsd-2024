package edu.miu.cs.cs489.aerotran.dto;

import java.time.LocalDateTime;
import java.util.List;

public record FlightDto(String flightNumber, Long airlineId,
                        Long airCraftTypeId,
                        Long airportOriginId, Long airportDestinationId,
                        List<FareDetailsDto> fareDetailsDto,
                        LocalDateTime departureDateTime,
                        LocalDateTime arrivalDateTime
                        ) {




}
