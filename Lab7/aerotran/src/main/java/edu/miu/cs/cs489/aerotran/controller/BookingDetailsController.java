package edu.miu.cs.cs489.aerotran.controller;

import edu.miu.cs.cs489.aerotran.dto.BookingDetailsDto;
import edu.miu.cs.cs489.aerotran.dto.FlightDto;
import edu.miu.cs.cs489.aerotran.model.BookingDetail;
import edu.miu.cs.cs489.aerotran.model.Flight;
import edu.miu.cs.cs489.aerotran.service.BookingDetailsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/booking-detail")
@Slf4j
public class BookingDetailsController {


    @Autowired
    private BookingDetailsService bookingDetailsService;

    @PostMapping("/")
    public ResponseEntity<?> saveBookingDetails(@RequestBody BookingDetailsDto bookingDetailsDto) throws Exception {
        log.info("Inside saveBookingDetails method of BookingDetailsController ");
        bookingDetailsService.saveBookingDetails(bookingDetailsDto);
        return  new ResponseEntity<>("Saved Successfully", HttpStatus.CREATED);
    }

    @PutMapping("/{bookingId}")
    public ResponseEntity<?> updateBookingDetails(@PathVariable Long bookingId,@RequestBody BookingDetailsDto bookingDetailsDto) throws Exception {
        log.info("Inside updateBookingDetails method of BookingDetails Controller");
        bookingDetailsService.updateBookingDetails(bookingId,bookingDetailsDto);
        return  new ResponseEntity<>("Updated Successfully",HttpStatus.OK);
    }

    @GetMapping("/{bookingId}")
    public ResponseEntity<?> getBooking(@PathVariable Long bookingId){
        log.info("Inside getBooking method of BookingDetails Controller");
        return  new ResponseEntity<BookingDetail>(bookingDetailsService.getBookingDetailsById(bookingId),HttpStatus.OK);
    }



    @GetMapping("/")
    public ResponseEntity<?> getAllBooking(){
        log.info("Inside getAllBooking method of BookingDetails Controller");
        return  new ResponseEntity<>(bookingDetailsService.getAllBookingDetail(),HttpStatus.OK);
    }

}
