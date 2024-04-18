package edu.miu.cs.cs489.aerotran.controller;

import edu.miu.cs.cs489.aerotran.dto.UserDto;
import edu.miu.cs.cs489.aerotran.model.User;
import edu.miu.cs.cs489.aerotran.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/")
    public ResponseEntity<?> saveUser(@RequestBody UserDto userDto) throws Exception {
        log.info("Inside saveUser method of User Controller");
       userService.saveUser(userDto);
        return  new ResponseEntity<>("Saved Successfully",HttpStatus.CREATED);
    }

    @PutMapping("/{userId}")
    public ResponseEntity<?> updateUser(@PathVariable Long userId,@RequestBody UserDto userDto) throws Exception {
        log.info("Inside updateUser method of User Controller");
        User user = userService.updateUser(userDto);
        return  new ResponseEntity<>("Updated Syccessfully",HttpStatus.OK);
    }


    @GetMapping("/{userId}")
    public ResponseEntity<?> getUser(@PathVariable Long userId){
        log.info("Inside getUser method of User Controller");
        return  new ResponseEntity<User>( userService.getUserById(userId),HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<?> getAllUser(){
        log.info("Inside getAllUser method of User Controller");
        return  new ResponseEntity<>(userService.getAllUser(),HttpStatus.OK);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<?> deleteUser(@PathVariable Long userId){
        log.info("Inside deleteUser method of User Controller");
        userService.deleteByUserId(userId);
        return new ResponseEntity<>(HttpStatus.OK);

    }
}
