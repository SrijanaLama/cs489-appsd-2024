package edu.miu.cs.cs489.aerotran.service;

import edu.miu.cs.cs489.aerotran.model.Passenger;
import edu.miu.cs.cs489.aerotran.repository.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


public interface PassengerService {

  void savePassenger(Passenger passenger);

  Passenger getPassengerById(String passengerId);

  Passenger updatePassenger(Passenger passenger);

  void deletePassengerById(String passengerId);

  List<Passenger> getAllPassenger( );



}
