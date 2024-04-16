package edu.miu.cs.cs489.aerotran.model.lookup;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Airline {

    @Id
    private Long airlineId;
    private String airlineName;

}
