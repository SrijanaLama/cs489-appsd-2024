package edu.miu.cs.cs489.aerotran.controller;

import edu.miu.cs.cs489.aerotran.dto.FlightDto;
import edu.miu.cs.cs489.aerotran.model.Flight;
import edu.miu.cs.cs489.aerotran.service.SearchService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/search")
@Slf4j
public class SearchController {

    @Autowired
    private SearchService searchService;

    @GetMapping("/")
    public ResponseEntity<?> getAllUser(){
        log.info("Inside getAllUser method of SearchController");
        return  new ResponseEntity<>("Search COmplete", HttpStatus.OK);
    }

    @GetMapping("/flights")
    public ResponseEntity<?> getFlightByFromToORDepartureDate(
            @RequestParam(name = "from",required = false) Long from,
            @RequestParam(name="to",required = false) Long to,
            @RequestParam(name="departureDateTime",required = false) LocalDateTime  departureDateTime) {
        log.info("Inside getFlightByFromToORDepartureDate of SearchController");
        List<Flight> flights = searchService.searchFlight(from,to,departureDateTime);
        return ResponseEntity.ok(flights);
    }




}