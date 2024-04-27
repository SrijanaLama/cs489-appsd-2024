package edu.miu.cs.cs489.aerotran.repository;

import edu.miu.cs.cs489.aerotran.dto.FlightDto;
import edu.miu.cs.cs489.aerotran.model.Flight;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
@Repository
public interface FlightRepository extends JpaRepository<Flight,Long>
    ,JpaSpecificationExecutor<Flight>
        {

    Optional<Flight> findByFlightId(Long flightId);

    void deleteFlightByFlightId(Long flightId);


    List<Flight> findAll(Specification<Flight> specification);

}
