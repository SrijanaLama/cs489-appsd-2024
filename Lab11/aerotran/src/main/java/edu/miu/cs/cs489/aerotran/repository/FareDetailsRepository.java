package edu.miu.cs.cs489.aerotran.repository;

import edu.miu.cs.cs489.aerotran.model.FareDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FareDetailsRepository extends JpaRepository<FareDetails,Long> {
}
