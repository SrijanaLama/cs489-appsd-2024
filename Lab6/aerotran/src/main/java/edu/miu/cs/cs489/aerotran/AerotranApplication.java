package edu.miu.cs.cs489.aerotran;

import edu.miu.cs.cs489.aerotran.model.Passenger;
import edu.miu.cs.cs489.aerotran.model.User;
import edu.miu.cs.cs489.aerotran.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class AerotranApplication  implements CommandLineRunner {

	@Autowired
	private UserService userService;

	public static void main(String[] args) {

		SpringApplication.run(AerotranApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {



		// create user
		User user1 = new User(1L, "admin", "admin", "admin@gmail.com", "123456");
		User user2 = new User(2L, "admin2", "admin2", "admin@gmail.com", "123456");

		//save user
		userService.saveUser(user1);
		userService.saveUser(user2);

		//get All User
		System.out.println("Get All Users");
		userService.getAllUser().forEach(System.out::println);

		user1.setUserName("admin1");
		user1.setPassword("admin1");

		System.out.println("Update User1 to username");
		userService.updateUser(user1);
		//find by id
		System.out.println(userService.getUserById(1L).toString());


		User passenger1 = new Passenger(3L, "passenger", "passenger", "passenger@gmail.com", "5444","2323","regular");

		userService.saveUser(passenger1);
		userService.getAllUser().forEach(System.out::println);

	}
}
