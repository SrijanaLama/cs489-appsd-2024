package edu.miu.cs.cs489.aerotran.repository.lookup;

import edu.miu.cs.cs489.aerotran.model.lookup.Airport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirportRepository extends JpaRepository<Airport,Long> {
}
