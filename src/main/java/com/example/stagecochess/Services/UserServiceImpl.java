package com.example.stagecochess.Services;

import com.example.stagecochess.Entities.User;
import com.example.stagecochess.Interfaces.UserService;
import com.example.stagecochess.Repository.UserRepository;
import com.example.stagecochess.Response.LoginResponse;
import com.example.stagecochess.dto.LoginDto;
import com.example.stagecochess.dto.UserDTO;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@AllArgsConstructor
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserServiceImpl implements UserService {

    PasswordEncoder passwordEncoder;
    UserRepository userRepository;

    @Override
    public LoginResponse loginUser(LoginDto loginDto) {
        // Trouver l'utilisateur par email
        User user = userRepository.findByEmail(loginDto.getEmail()).orElse(null);

        if (user == null) {
            // L'utilisateur n'existe pas
            return new LoginResponse("Email does not exist", false);
        }

        // Vérifier le mot de passe
        boolean isPwdRight = passwordEncoder.matches(loginDto.getPassword(), user.getPassword());

        if (isPwdRight) {
            // Mot de passe correct, renvoyer l'ID de l'utilisateur
            return new LoginResponse("Login success", true, user.getUserId());
        } else {
            // Mot de passe incorrect
            return new LoginResponse("Password does not match", false);
        }
    }



    @Override
    public String addUser(UserDTO userDTO) {
        User user = new User(
                userDTO.getUsername(),
                userDTO.getEmail(),
                this.passwordEncoder.encode(userDTO.getPassword())
        );
        userRepository.save(user);
        return user.getUsername();
    }
}
