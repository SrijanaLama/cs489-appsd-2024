package edu.miu.cs.cs489.aerotran.service;

import edu.miu.cs.cs489.aerotran.dto.BookingDetailsDto;
import edu.miu.cs.cs489.aerotran.dto.PassengerDto;
import edu.miu.cs.cs489.aerotran.model.BookingDetail;
import edu.miu.cs.cs489.aerotran.model.Passenger;

import java.util.List;

public interface BookingDetailsService {

    void saveBookingDetails(BookingDetailsDto bookingDetailsDto);

    BookingDetail getBookingDetailsById(Long bookingId);

    BookingDetail updateBookingDetails(Long bookingId,BookingDetailsDto bookingDetailDto);

    void deleteBookingDetailById(Long passengerId);

    List<BookingDetail> getAllBookingDetail( );
}
