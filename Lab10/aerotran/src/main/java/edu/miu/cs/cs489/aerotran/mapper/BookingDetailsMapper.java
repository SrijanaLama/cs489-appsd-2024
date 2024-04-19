package edu.miu.cs.cs489.aerotran.mapper;

import edu.miu.cs.cs489.aerotran.dto.BookingDetailsDto;
import edu.miu.cs.cs489.aerotran.model.BookingDetail;
import edu.miu.cs.cs489.aerotran.repository.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class BookingDetailsMapper {

    @Autowired
    private PassengerRepository passengerRepository;


    public BookingDetail convertDtoToEntity(BookingDetailsDto bookingDetailsDto){
       return  Optional.ofNullable(bookingDetailsDto).map(
                dto ->{
                    return new BookingDetail(dto.seatNumber(),dto.status(),
                            passengerRepository.getReferenceById(dto.passengerId()));
                }
        ).orElse(null);

    }
}
