package edu.miu.cs.cs489.aerotran.mapper;

import edu.miu.cs.cs489.aerotran.dto.PassengerDto;
import edu.miu.cs.cs489.aerotran.model.Passenger;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class PasengerMapper {

    public Passenger convertDtoToEntity(PassengerDto passengerDto){
        return Optional.ofNullable(passengerDto)
                .map(dto ->{
                    return  new Passenger(dto.firstName() ,dto.lastName(),dto.dateOfBirth(),dto.passengerStatus(),
                    dto.userName(),dto.email(),dto.phoneNumber());
                }).orElse(null);
    }
}
