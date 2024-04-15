package edu.miu.cs.cs489.aerotran.service.impl;


import edu.miu.cs.cs489.aerotran.model.User;
import edu.miu.cs.cs489.aerotran.repository.UserRepository;
import edu.miu.cs.cs489.aerotran.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void saveUser(User user) {
        userRepository.save(user);
    }

    @Override
    public User getUserById(Long userId) {
        return userRepository.findByUserId(userId).orElse(null);
    }

    @Override
    public User updateUser(User user) {
        return userRepository.save(user);

    }

    @Override
    public void deleteByUserId(Long userId) {
        userRepository.deleteByUserId(userId);
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }
}
