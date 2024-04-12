package edu.miu.cs.cs489.aerotran.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Flights {
    @Id
    private String flightNumber;
    @OneToOne
    private Airline airline;
    private String airCraftType;
    private String capacity;
    @OneToOne
    private Airport origin;
    @OneToOne
    private Airport destination;





}
