package edu.miu.cs.cs489.aerotran.model.lookup;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Airport {

    @Id
    private Long airportId;

    @NotBlank(message = "AirportCode is Required")
    @Column(nullable = false,unique = true)
    private String airportCode;

    @NotBlank(message = "AirportName is Required")
    @Column(nullable = false)
    private String airportName;

    @NotBlank(message = "Location is Required")
    @Column(nullable = false)
    private String airportLocation;
}
