package edu.miu.cs.cs489.aerotran.controller;

import edu.miu.cs.cs489.aerotran.dto.PassengerDto;
import edu.miu.cs.cs489.aerotran.dto.UserDto;
import edu.miu.cs.cs489.aerotran.model.Passenger;
import edu.miu.cs.cs489.aerotran.model.User;
import edu.miu.cs.cs489.aerotran.service.PassengerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/passenger")
@Slf4j
public class PassengerController {

    @Autowired
    private PassengerService passengerService;


    @PostMapping("/")
    public ResponseEntity<?> savePassenger(@RequestBody PassengerDto passengerDto) throws Exception {
        log.info("Inside savePassenger method of PassengerController ");
        passengerService.savePassenger(passengerDto);
        return  new ResponseEntity<>("Saved Successfully", HttpStatus.CREATED);
    }

    @PutMapping("/{passengerId}")
    public ResponseEntity<?> updatePassenger(@PathVariable Long passengerId,@RequestBody PassengerDto passengerDto) throws Exception {
        log.info("Inside updateUser method of Passenger Controller");
        Passenger passenger = passengerService.updatePassenger(passengerDto);
        return  new ResponseEntity<>("Updated Successfully",HttpStatus.OK);
    }

    @GetMapping("/{passengerId}")
    public ResponseEntity<?> getPassenger(@PathVariable Long passengerId){
        log.info("Inside getUser method of Passenger Controller");
        return  new ResponseEntity<Passenger>( passengerService.getPassengerById(passengerId),HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<?> getAllPassenger(){
        log.info("Inside getAllPassenger method of Passenger Controller");
        return  new ResponseEntity<>(passengerService.getAllPassenger(),HttpStatus.OK);
    }

    @DeleteMapping("/{passengerId}")
    public ResponseEntity<?> deletePassenger(@PathVariable Long passengerId){
        log.info("Inside deletePassenger method of Passenger Controller");
        passengerService.deletePassengerById(passengerId);
        return new ResponseEntity<>(HttpStatus.OK);

    }
}
