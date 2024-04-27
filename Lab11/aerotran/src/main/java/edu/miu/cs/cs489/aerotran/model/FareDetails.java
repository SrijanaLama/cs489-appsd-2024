package edu.miu.cs.cs489.aerotran.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString
public class FareDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long fareDetailsId;

    @NotBlank(message = "Fare is Required")
    @Column(nullable = false)
    private String fare;
    @NotBlank(message = "SeatType is Required")
    @Column(nullable = false)
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
