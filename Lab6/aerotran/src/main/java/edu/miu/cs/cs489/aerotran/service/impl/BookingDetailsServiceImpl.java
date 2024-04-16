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
        return bookingDetailsRepository.getReferenceById(bookingId);
    }

    @Override
    public BookingDetail updateBookingDetails(BookingDetail bookingDetail) {
        return bookingDetailsRepository.save(bookingDetail);
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
