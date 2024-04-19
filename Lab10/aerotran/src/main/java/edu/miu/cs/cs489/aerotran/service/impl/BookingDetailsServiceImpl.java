package edu.miu.cs.cs489.aerotran.service.impl;

import edu.miu.cs.cs489.aerotran.dto.BookingDetailsDto;
import edu.miu.cs.cs489.aerotran.mapper.BookingDetailsMapper;
import edu.miu.cs.cs489.aerotran.model.BookingDetail;
import edu.miu.cs.cs489.aerotran.repository.BookingDetailsRepository;
import edu.miu.cs.cs489.aerotran.service.BookingDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingDetailsServiceImpl implements BookingDetailsService {

    @Autowired
    private BookingDetailsRepository bookingDetailsRepository;

    @Autowired
    private BookingDetailsMapper bookingDetailsMapper;


    @Override
    public void saveBookingDetails(BookingDetailsDto bookingDetailsDto) {
        bookingDetailsRepository.save(bookingDetailsMapper.convertDtoToEntity(bookingDetailsDto));
    }

    @Override
    public BookingDetail getBookingDetailsById(Long bookingId) {
        return bookingDetailsRepository.findById(bookingId).orElse(null);
    }

    @Override
    public BookingDetail updateBookingDetails(Long bookingId,BookingDetailsDto bookingDetailsDto) {

        BookingDetail bookingDetail = bookingDetailsRepository.findById(bookingId)
                .orElseThrow(()->new RuntimeException("No Details found"));
        bookingDetail.setStatus(bookingDetailsDto.status());
        bookingDetail.setSeatNumber(bookingDetailsDto.seatNumber());

        bookingDetailsRepository.save(bookingDetail);

       // return bookingDetailsRepository.save(bookingDetail);
        return null;
    }

    @Override
    public void deleteBookingDetailById(Long passengerId) {
        bookingDetailsRepository.deleteById(passengerId);
    }

    @Override
    public List<BookingDetail> getAllBookingDetail() {
        return bookingDetailsRepository.findAll();
    }
}
