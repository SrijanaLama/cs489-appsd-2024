package edu.miu.cs.cs489.aerotran.dto;

import java.util.Collections;
import java.util.List;

public record UserDto(Long userId,
                      String userName,
                      String password,
                      String email,
                      String phoneNumber,
                      List<Long> roles
) {
    public UserDto(String userName, String password, String email, String phoneNumber, List<Long> roles) {
        this(null, userName, password, email, phoneNumber, roles);
    }


    // Constructor for UserDto without roles
    public UserDto(String userName, String password, String email, String phoneNumber) {
        this(userName, password, email, phoneNumber, Collections.emptyList());
    }
}
