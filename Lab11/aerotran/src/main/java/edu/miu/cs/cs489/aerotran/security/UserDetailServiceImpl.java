package edu.miu.cs.cs489.aerotran.security;

import edu.miu.cs.cs489.aerotran.model.User;
import edu.miu.cs.cs489.aerotran.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Primary
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private  UserRepository userRepository;




    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByUserName(username);
        return new UserPrincipal(user.orElseThrow(()-> new UsernameNotFoundException("User not Found")));

    }
}
