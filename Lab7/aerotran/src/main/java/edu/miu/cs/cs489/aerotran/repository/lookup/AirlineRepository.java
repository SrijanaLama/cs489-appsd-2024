package edu.miu.cs.cs489.aerotran.repository.lookup;

import edu.miu.cs.cs489.aerotran.model.lookup.Airline;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirlineRepository extends JpaRepository<Airline,Long> {
}
