package edu.miu.cs.cs489.aerotran.service.impl;

import edu.miu.cs.cs489.aerotran.dto.FlightDto;
import edu.miu.cs.cs489.aerotran.model.Flight;
import edu.miu.cs.cs489.aerotran.repository.FlightRepository;
import edu.miu.cs.cs489.aerotran.repository.FlightSpecification;
import edu.miu.cs.cs489.aerotran.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class SearchServiceImpl implements SearchService {

    @Autowired
    private  FlightRepository flightRepository;

    @Override
    public List<Flight> searchFlight(Long from, Long to, LocalDateTime departureDateTime) {
        final Specification<Flight> specification =
                FlightSpecification.fliterFlight(from, to,departureDateTime);
        final List<Flight> flights = flightRepository.findAll(specification);
        //flights.stream().forEach(System.out::println);
        return flights;
    }
}
