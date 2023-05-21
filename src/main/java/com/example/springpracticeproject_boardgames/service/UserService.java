package com.example.springpracticeproject_boardgames.service;

import com.example.springpracticeproject_boardgames.dto.LoginDTO;
import com.example.springpracticeproject_boardgames.dto.RegisterDTO;
import com.example.springpracticeproject_boardgames.entity.User;
import com.example.springpracticeproject_boardgames.exception.AuthenticationServiceException;
import com.example.springpracticeproject_boardgames.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UserService {
    private UserRepository userRepository;
    private User logged;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void createUser(RegisterDTO registerDTO){
        User user = new User(registerDTO.getUserEmail(),registerDTO.getPassword1());
        userRepository.save(user);
    }

    public void loginUser(LoginDTO loginDTO){
        String errorMessage = "Wrong data";
        User user = userRepository.findByUserEmail(loginDTO.getUserEmail())
                .orElseThrow(()-> new AuthenticationServiceException(errorMessage));
        logged = user;
    }
}
