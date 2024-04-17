package edu.miu.cs.cs489.aerotran.service.impl;

import edu.miu.cs.cs489.aerotran.dto.PassengerDto;
import edu.miu.cs.cs489.aerotran.mapper.PasengerMapper;
import edu.miu.cs.cs489.aerotran.model.Passenger;
import edu.miu.cs.cs489.aerotran.model.User;
import edu.miu.cs.cs489.aerotran.model.UserRole;
import edu.miu.cs.cs489.aerotran.repository.PassengerRepository;
import edu.miu.cs.cs489.aerotran.repository.lookup.RoleRepository;
import edu.miu.cs.cs489.aerotran.service.PassengerService;
import edu.miu.cs.cs489.aerotran.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PassengerServiceImpl implements PassengerService {

    @Autowired
    private PassengerRepository passengerRepository;

    @Autowired
    private PasengerMapper passengMapper;

    @Autowired
    private UserService userService;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public void savePassenger(PassengerDto passengerDto) {
        Passenger passenger =passengMapper.convertDtoToEntity(passengerDto);

        User user = new User(passengerDto.userName(),passengerDto.userName(),passengerDto.email(),passengerDto.phoneNumber());
        UserRole  userRole = new UserRole(user,roleRepository.getReferenceById(1l));
        user.setUserRoles(List.of(userRole));

        Long userId =  userService.saveUser(user);
        passenger.setUserId(userId);

        passengerRepository.save(passenger);
    }

    @Override
    public Passenger getPassengerById(Long passengerId) {
        return passengerRepository.findByPassengerId(passengerId).orElse(null);
    }

    @Override
    public Passenger updatePassenger(PassengerDto passengerDto) {
        Passenger passenger =passengerRepository.getReferenceById(passengerDto.passengerId());
        passenger.copy(passengerDto.firstName(),passengerDto.lastName(),passengerDto.dateOfBirth(),
                passengerDto.passengerStatus(),passengerDto.userName(),passengerDto.email(),
                passengerDto.phoneNumber());


        passengerRepository.save(passenger);

        User user = userService.getUserById(passenger.getUserId());
        user.setUserName(passenger.getUserName());
        user.setEmail(passenger.getEmail());
        user.setPhoneNumber(passenger.getPhoneNumber());

        userService.saveUser(user);


        return passenger;
    }

    @Override
    public void deletePassengerById(Long passengerId) {
     passengerRepository.deleteById(passengerId);
    }

    @Override
    public List<Passenger> getAllPassenger() {
        return passengerRepository.findAll();
    }
}
