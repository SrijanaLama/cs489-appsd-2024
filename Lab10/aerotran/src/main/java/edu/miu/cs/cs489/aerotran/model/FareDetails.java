package edu.miu.cs.cs489.aerotran.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString
public class FareDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long fareDetailsId;
    private String fare;
    private String seatType;

    public FareDetails(String fare, String seatType) {
        this.fare = fare;
        this.seatType = seatType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FareDetails that)) return false;
        return Objects.equals(seatType, that.seatType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(seatType);
    }
}
