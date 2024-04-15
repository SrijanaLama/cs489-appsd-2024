package edu.miu.cs.cs489.aerotran.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class FlightSchedule {

    @Id
    private String flightSchedulesId;
    private LocalDateTime departureDateTime;
    private LocalDateTime arrivalDateTime;
}
