package com.example.stagecochess.Interfaces;

import com.example.stagecochess.Response.LoginResponse;
import com.example.stagecochess.dto.LoginDto;
import com.example.stagecochess.dto.UserDTO;

public interface UserService {

    LoginResponse loginUser(LoginDto loginDto);

    String addUser(UserDTO userDTO);
}
