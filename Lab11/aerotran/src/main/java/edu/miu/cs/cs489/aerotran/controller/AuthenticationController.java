package edu.miu.cs.cs489.aerotran.controller;

import edu.miu.cs.cs489.aerotran.dto.UserDto;
import edu.miu.cs.cs489.aerotran.model.User;

import edu.miu.cs.cs489.aerotran.security.JwtService;
import edu.miu.cs.cs489.aerotran.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@Slf4j
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public String loginUser(@RequestBody User user){
        Authentication authenticate = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(user.getUserName(),user.getPassword()));
                if(authenticate.isAuthenticated())
                    return jwtService.generateToken(userService.getUserByUserName(user.getUserName()));
                 else
                     throw  new UsernameNotFoundException("Invalid User Request");

        }


    @PostMapping("/create-user")
    public ResponseEntity<?> createUser(@RequestBody UserDto userDto) throws Exception {
        log.info("Inside saveUser method of User Controller");
        userService.saveUser(userDto);
        return  new ResponseEntity<>("Saved Successfully", HttpStatus.CREATED);
    }

    @GetMapping("/hello")
        public ResponseEntity<?> getHello() {
            log.info("Inside getHello method of User Controller");
            return  new ResponseEntity<>("Hello", HttpStatus.OK);
        }


}
