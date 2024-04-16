package edu.miu.cs.cs489.aerotran.service;

import edu.miu.cs.cs489.aerotran.dto.PassengerDto;
import edu.miu.cs.cs489.aerotran.model.Passenger;
import edu.miu.cs.cs489.aerotran.repository.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


public interface PassengerService {

  void savePassenger(PassengerDto passengerDto);

  Passenger getPassengerById(Long passengerId);

  Passenger updatePassenger(Passenger passenger);

  void deletePassengerById(Long passengerId);

  List<Passenger> getAllPassenger( );



}
