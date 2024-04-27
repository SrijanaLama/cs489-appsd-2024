package edu.miu.cs.cs489.aerotran.mapper;

import edu.miu.cs.cs489.aerotran.dto.FlightDto;
import edu.miu.cs.cs489.aerotran.dto.UserDto;
import edu.miu.cs.cs489.aerotran.model.FareDetails;
import edu.miu.cs.cs489.aerotran.model.Flight;
import edu.miu.cs.cs489.aerotran.model.User;
import edu.miu.cs.cs489.aerotran.model.UserRole;
import edu.miu.cs.cs489.aerotran.repository.lookup.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class UserMapper {

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User convertDtoToEntity(UserDto userDto) throws  Exception{
        return Optional.ofNullable(userDto)
                .map(dto ->{
                    User user = new User(dto.userName(),passwordEncoder.encode(dto.password()),dto.email(),dto.phoneNumber());
                    user.setUserRoles(dto.roles().stream().map(f->{
                        UserRole ur = new UserRole();
                        ur.setUser(user);
                        ur.setRole(roleRepository.getReferenceById(f));
                        return ur;
                    }).collect(Collectors.toList()));
                    return user;

                }).orElse(null);

    }


    public User convertDtoToEntityForUpdate(UserDto userDto) throws  Exception{
        return Optional.ofNullable(userDto)
                .map(dto ->{
                    User user = new User(dto.userId(),dto.userName(),dto.password(),dto.email(),dto.phoneNumber());
                    user.setUserRoles(dto.roles().stream().map(f->{
                        UserRole ur = new UserRole();
                        ur.setUser(user);
                        ur.setRole(roleRepository.getReferenceById(f));
                        return ur;
                    }).collect(Collectors.toList()));
                    return user;

                }).orElse(null);

    }
}
