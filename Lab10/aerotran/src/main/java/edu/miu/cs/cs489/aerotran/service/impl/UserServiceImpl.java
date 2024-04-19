package edu.miu.cs.cs489.aerotran.service.impl;


import edu.miu.cs.cs489.aerotran.dto.UserDto;
import edu.miu.cs.cs489.aerotran.mapper.UserMapper;
import edu.miu.cs.cs489.aerotran.model.Role;
import edu.miu.cs.cs489.aerotran.model.User;
import edu.miu.cs.cs489.aerotran.model.UserRole;
import edu.miu.cs.cs489.aerotran.repository.UserRepository;
import edu.miu.cs.cs489.aerotran.repository.UserRoleRepository;
import edu.miu.cs.cs489.aerotran.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;


    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserRoleRepository userRoleRepository;

    @Override
    public void saveUser(UserDto userDto) throws Exception {

        userRepository.save(userMapper.convertDtoToEntity(userDto));
    }

    @Override
    public User getUserById(Long userId) {

        log.info("Inside getUserById of UserServiceImpl");
        return userRepository.getReferenceById(userId);
    }

    @Override
    @Transactional
    public User updateUser(UserDto userDto) throws Exception {
        User nUserDetails = userMapper.convertDtoToEntityForUpdate(userDto);
        User oldUser = userRepository.getReferenceById(userDto.userId());
        oldUser.copy(nUserDetails.getUserName(),nUserDetails.getEmail(),nUserDetails.getPhoneNumber());
        //oldUser.setUserRoles(nUserDetails.getUserRoles());
        List<UserRole> oUserRoles = oldUser.getUserRoles();
        List<UserRole> nUserRoles = nUserDetails.getUserRoles();
        oldUser.getUserRoles().stream()
                .forEach(ur -> {
                    if (nUserRoles.contains(ur)) {
                        ur.setStatus("ACTIVE");
                    } else {
                        ur.setStatus("INACTIVE");
                    }
                });

        // Save the updated user (including userRoles updates)
        nUserRoles.stream()
                .filter(ur -> !oUserRoles.contains(ur))
                .forEach(ur -> {
                    oldUser.getUserRoles().add(ur); // Add to oldUser's userRoles collection
                });
        userRepository.save(oldUser);



        return oldUser;

    }

    @Override
    public void deleteByUserId(Long userId) {
        userRepository.deleteById(userId);
    }

    @Override
    public List<User> getAllUser() {
        log.info("Inside getAllUser of UserServiceImpl");
        return userRepository.findAll();
    }

    @Override
    public Long saveUser(User user) {
        return userRepository.save(user).getUserId();
    }
}
