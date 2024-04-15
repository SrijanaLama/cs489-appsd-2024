package edu.miu.cs.cs489.aerotran.service.impl;

import edu.miu.cs.cs489.aerotran.model.Passenger;
import edu.miu.cs.cs489.aerotran.repository.PassengerRepository;
import edu.miu.cs.cs489.aerotran.service.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PassengerServiceImpl implements PassengerService {

    @Autowired
    private PassengerRepository passengerRepository;

    @Override
    public void savePassenger(Passenger passenger) {
        passengerRepository.save(passenger);
    }

    @Override
    public Passenger getPassengerById(String passengerId) {
        return passengerRepository.findByPassengerId(passengerId).orElse(null);
    }

    @Override
    public Passenger updatePassenger(Passenger passenger) {
        return passengerRepository.save(passenger);
    }

    @Override
    public void deletePassengerById(String passengerId) {
     passengerRepository.deleteByPassengerId(passengerId);
    }

    @Override
    public List<Passenger> getAllPassenger() {
        return passengerRepository.findAll();
    }
}
