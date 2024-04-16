package edu.miu.cs.cs489.aerotran.service;

import edu.miu.cs.cs489.aerotran.dto.UserDto;
import edu.miu.cs.cs489.aerotran.model.Passenger;
import edu.miu.cs.cs489.aerotran.model.User;

import java.util.List;

public interface UserService {

    void saveUser(UserDto userDto) throws Exception;

    User getUserById(Long userId);

    User updateUser(User user);

    void deleteByUserId(Long userId);

    List<User> getAllUser( );

    Long saveUser(User user);
}
