package edu.miu.cs.cs489.aerotran;

import edu.miu.cs.cs489.aerotran.dto.*;
import edu.miu.cs.cs489.aerotran.model.Role;
import edu.miu.cs.cs489.aerotran.model.lookup.AircraftType;
import edu.miu.cs.cs489.aerotran.model.lookup.Airline;
import edu.miu.cs.cs489.aerotran.model.lookup.Airport;
import edu.miu.cs.cs489.aerotran.model.User;
import edu.miu.cs.cs489.aerotran.repository.lookup.AircraftTypeRepository;
import edu.miu.cs.cs489.aerotran.repository.lookup.AirlineRepository;
import edu.miu.cs.cs489.aerotran.repository.lookup.AirportRepository;
import edu.miu.cs.cs489.aerotran.repository.lookup.RoleRepository;
import edu.miu.cs.cs489.aerotran.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@SpringBootApplication
@EnableJpaRepositories
@EnableTransactionManagement
public class AerotranApplication  implements CommandLineRunner {

	@Autowired
	private UserService userService;

	@Autowired
	private FlightService flightService;

	@Autowired
	private PassengerService passengerService;

	@Autowired
	private BookingDetailsService bookingDetailsService;

	@Autowired
	private AirportRepository airportRepository;

	@Autowired
	private AirlineRepository airlineRepository;

	@Autowired
	private AircraftTypeRepository aircraftTypeRepository;

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private SearchService searchService;






	public static void main(String[] args) {

		SpringApplication.run(AerotranApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		//save lookUpData
		saveLookUp();


		// create user
		UserDto user1 = new UserDto( "admin", "admin", "admin@gmail.com", "123456",
				List.of(1L,2L));
		UserDto user2 = new UserDto( "srijana", "srijana", "srijana@gmail.com", "123456",
				List.of(3L,2L));

		//save user
		userService.saveUser(user1);
		userService.saveUser(user2);


		// save Passenger
		// Passenger 1
		PassengerDto passenger1 = new PassengerDto("Alice", "Smith", LocalDate.of(1995, 8, 20), "Silver", "alice_smith", "alice.smith@example.com", "555-123-4567");

		// Passenger 2
		PassengerDto passenger2 = new PassengerDto("Bob", "Johnson", LocalDate.of(1988, 4, 10), "Gold", "bobby88", "bob.johnson@example.com", "555-987-6543");

		// Passenger 3
		PassengerDto passenger3 = new PassengerDto("Emily", "Davis", LocalDate.of(1992, 11, 25), "Bronze", "emilyd", "emily.davis@example.com", "555-777-8888");

		// Passenger 4
		PassengerDto passenger4 = new PassengerDto("Michael", "Brown", LocalDate.of(1980, 7, 15), "Gold", "mbrown", "michael.brown@example.com", "555-222-3333");

		// Passenger 50o
		PassengerDto passenger5 = new PassengerDto("Sophia", "Clark", LocalDate.of(1998, 2, 5), "Silver", "sophia_c", "sophia.clark@example.com", "555-444-5555");


		passengerService.savePassenger(passenger1);
		passengerService.savePassenger(passenger2);
		passengerService.savePassenger(passenger3);
		passengerService.savePassenger(passenger4);
		passengerService.savePassenger(passenger5);




		//Flight Details

		FlightDto flightDto1 = new FlightDto(
				"ABC123",    // flightNumber
				1L,          // airlineId
				2L,          // airCraftTypeId
				3l,5l,
				List.of(     // List of FairDetailsDto
						new FareDetailsDto("100.0", "Economy"),
						new FareDetailsDto("150.0", "Business")
				),
				LocalDateTime.of(2024, 4, 16, 10, 30),  // departureDateTime
				LocalDateTime.of(2024, 4, 16, 13, 0)    // arrivalDateTime
		);

		FlightDto flightDto2 = new FlightDto(
				"XYT444",    // flightNumber
				3L,          // airlineId
				1L,          // airCraftTypeId
				1l,4l,
				List.of(     // List of FairDetailsDto
						new FareDetailsDto("15.0", "Economy"),
						new FareDetailsDto("200.0", "Business")
				),
				LocalDateTime.of(2024, 4, 10, 10, 30),  // departureDateTime
				LocalDateTime.of(2024, 4, 10, 13, 0)    // arrivalDateTime
		);

		FlightDto flightDto3 = new FlightDto(
				"XY5444",    // flightNumber
				3L,          // airlineId
				2L,          // airCraftTypeId
				3l,4l,
				List.of(     // List of FairDetailsDto
						new FareDetailsDto("15.0", "Economy"),
						new FareDetailsDto("200.0", "Business")
				),
				LocalDateTime.of(2024, 4, 10, 10, 30),  // departureDateTime
				LocalDateTime.of(2024, 4, 10, 13, 0)    // arrivalDateTime
		);

		FlightDto flightDto4 = new FlightDto(
				"WY5444",    // flightNumber
				3L,          // airlineId
				2L,          // airCraftTypeId
				3l,4l,
				List.of(     // List of FairDetailsDto
						new FareDetailsDto("15.0", "Economy"),
						new FareDetailsDto("200.0", "Business")
				),
				LocalDateTime.of(2024, 4, 11, 11, 30),  // departureDateTime
				LocalDateTime.of(2024, 4, 12, 13, 0)    // arrivalDateTime
		);



		flightService.saveFlight(flightDto1);
		flightService.saveFlight(flightDto2);
		flightService.saveFlight(flightDto3);
		flightService.saveFlight(flightDto4);



		// Booking Details
		// Booking 1
		BookingDetailsDto booking1 = new BookingDetailsDto("A12", "Confirmed", 1L,1L);

		// Booking 2
		BookingDetailsDto booking2 = new BookingDetailsDto("B34", "Pending", 2L,3L);

		// Booking 3
		BookingDetailsDto booking3 = new BookingDetailsDto("C56", "Cancelled", 1L,3L);

		// Booking 4
		BookingDetailsDto booking4 = new BookingDetailsDto("D78", "Confirmed", 3L,2L);

		// Booking 5
		BookingDetailsDto booking5 = new BookingDetailsDto("E90", "Pending", 3L,2L);

		// Booking 6
		BookingDetailsDto booking6 = new BookingDetailsDto("F23", "Confirmed", 4L,4l);


		bookingDetailsService.saveBookingDetails(booking1);
		bookingDetailsService.saveBookingDetails(booking2);
		bookingDetailsService.saveBookingDetails(booking3);
		bookingDetailsService.saveBookingDetails(booking4);
		bookingDetailsService.saveBookingDetails(booking5);
		bookingDetailsService.saveBookingDetails(booking6);

		printDetails();




	}

	private void printDetails() {
		System.out.println("========User Details =========");
		userService.getAllUser().forEach(System.out::println);
		System.out.println("**********FLight Details *********");
		flightService.getAllFlights().forEach(System.out::println);

		System.out.println("**********Passenger Details *********");

		passengerService.getAllPassenger().forEach(System.out::println);

		System.out.println("********** Booking Details *********");
		bookingDetailsService.getAllBookingDetail().forEach(System.out::println);


	}

	private void saveLookUp() {
		//save airline and airport
		Airport airport1 = new Airport(1L, "LAX", "Los Angeles International Airport", "Los Angeles, USA");
		Airport airport2 = new Airport(2L, "JFK", "John F. Kennedy International Airport", "New York City, USA");
		Airport airport3 = new Airport(3L, "LHR", "London Heathrow Airport", "London, UK");
		Airport airport4 = new Airport(4L, "CDG", "Charles de Gaulle Airport", "Paris, France");
		Airport airport5 = new Airport(5L, "SYD", "Sydney Kingsford Smith Airport", "Sydney, Australia");
		Airport airport6 = new Airport(6L, "HND", "Haneda Airport", "Tokyo, Japan");
		Airport airport7 = new Airport(7L, "DXB", "Dubai International Airport", "Dubai, UAE");
		Airport airport8 = new Airport(8L, "SIN", "Singapore Changi Airport", "Singapore");
		Airport airport9 = new Airport(9L, "AMS", "Amsterdam Airport Schiphol", "Amsterdam, Netherlands");
		Airport airport10 = new Airport(10L, "PEK", "Beijing Capital International Airport", "Beijing, China");

		airportRepository.saveAll(List.of(airport1,airport2,airport3,airport4,airport5,airport6,airport7,airport8,airport9,airport10));

		Airline airline1 = new Airline(1L, "American Airlines");
		Airline airline2 = new Airline(2L, "Delta Air Lines");
		Airline airline3 = new Airline(3L, "United Airlines");
		Airline airline4 = new Airline(4L, "Emirates");
		Airline airline5 = new Airline(5L, "Singapore Airlines");


		airlineRepository.saveAll(List.of(airline1,airline2,airline3,airline4,airline5));


		AircraftType type1 = new AircraftType(1L, "Boeing 737", "Narrow-body jet airliner");
		AircraftType type2 = new AircraftType(2L, "Airbus A320", "Narrow-body jet airliner");
		AircraftType type3 = new AircraftType(3L, "Boeing 777", "Wide-body jet airliner");
		AircraftType type4 = new AircraftType(4L, "Airbus A380", "Double-deck, wide-body jet airliner");


		aircraftTypeRepository.saveAll(List.of(type1,type2,type3,type4));


		Role role1 = new Role("Passenger");
		Role role2 = new Role("Agent");
		Role role3 = new Role("Admin");

		roleRepository.saveAll(List.of(role1,role2,role3));

		searchService.searchFlight(3l,2l,null);




	}
}
