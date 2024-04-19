package edu.miu.cs.cs489.aerotran.controller;

import edu.miu.cs.cs489.aerotran.dto.FlightDto;
import edu.miu.cs.cs489.aerotran.dto.PassengerDto;
import edu.miu.cs.cs489.aerotran.model.Flight;
import edu.miu.cs.cs489.aerotran.model.Passenger;
import edu.miu.cs.cs489.aerotran.service.FlightService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/flight")
@Slf4j
public class FlightController {

    @Autowired
    private FlightService flightService;

    @PostMapping("/")
    public ResponseEntity<?> saveFlight(@RequestBody FlightDto flightDto) throws Exception {
        log.info("Inside saveFlight method of FlightController ");
        flightService.saveFlight(flightDto);
        return  new ResponseEntity<>("Saved Successfully", HttpStatus.CREATED);
    }

    @PutMapping("/{flightId}")
    public ResponseEntity<?> updateFlight(@PathVariable Long flightId,@RequestBody FlightDto flightDto) throws Exception {
        log.info("Inside updateFlight method of Flight Controller");
        flightService.updateFlight(flightId,flightDto);
        return  new ResponseEntity<>("Updated Successfully",HttpStatus.OK);
    }

    @GetMapping("/{flightId}")
    public ResponseEntity<?> getFlight(@PathVariable Long flightId){
        log.info("Inside getFlight method of Flight Controller");
        return  new ResponseEntity<Flight>( flightService.getFlightsById(flightId),HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<?> getAllFlight(){
        log.info("Inside getAllFlight method of FLight Controller");
        return  new ResponseEntity<>(flightService.getAllFlights(),HttpStatus.OK);
    }

    @DeleteMapping("/{flightId}")
    public ResponseEntity<?> deleteFlight(@PathVariable Long flightId){
        log.info("Inside deleteFlight method of Flight Controller");
        flightService.deleteFlightByFlightId(flightId);
        return new ResponseEntity<>(HttpStatus.OK);

    }
}
