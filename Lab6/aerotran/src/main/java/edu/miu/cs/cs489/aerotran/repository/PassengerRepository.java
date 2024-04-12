package edu.miu.cs.cs489.aerotran.repository;

import edu.miu.cs.cs489.aerotran.model.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PassengerRepository extends JpaRepository<Passenger,Long> {
 Optional<Passenger> findByPassengerId(String passengerId);
 void deleteByPassengerId(String passengerId);

}
