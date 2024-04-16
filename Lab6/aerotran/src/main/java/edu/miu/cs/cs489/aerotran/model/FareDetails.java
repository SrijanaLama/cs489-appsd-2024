package edu.miu.cs.cs489.aerotran.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString
public class FareDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long fareDetailsId;
    private String fair;
    private String seatType;

    public FareDetails(String fair, String seatType) {
        this.fair = fair;
        this.seatType = seatType;
    }
}
