package edu.miu.cs.cs489.aerotran.repository;

import edu.miu.cs.cs489.aerotran.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FlightRepository extends JpaRepository<Flight,Long> {

    Optional<Flight> findByFlightId(Long flightId);

    void deleteFlightByFlightId(Long flightId);
}
