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
public class AircraftType {

    @Id
    private Long aircraftTypeId;

    @NotBlank(message = "Type is Required")
    @Column(nullable = false,unique = true)
    private String typeName;

    private String description;


}
