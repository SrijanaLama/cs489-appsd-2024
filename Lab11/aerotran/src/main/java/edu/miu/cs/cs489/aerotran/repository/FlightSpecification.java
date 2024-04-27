package edu.miu.cs.cs489.aerotran.repository;

import edu.miu.cs.cs489.aerotran.model.Flight;
import io.micrometer.common.util.StringUtils;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDateTime;

public class FlightSpecification {

    public static Specification<Flight> fliterFlight(Long from, Long to, LocalDateTime departureDateTime) {
        return (root, query, criteriaBuilder) -> {


                Predicate fromPredicate =
                        criteriaBuilder.equal(root.get("origin").get("airportId"),from);
                Predicate toPredicate =
                        criteriaBuilder.equal(root.get("destination").get("airportId"), to);


                Predicate departureDateTimePredicate =
                        criteriaBuilder.equal(root.get("departureDateTime"), departureDateTime);

            return criteriaBuilder.and(fromPredicate,toPredicate);



        };
    }

    private static String likePattern(String value) {
        return "%" + value + "%";
    }
}