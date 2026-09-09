package com.metrio.Metrio.service;

import com.metrio.Metrio.models.User;
import com.metrio.Metrio.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UserRepository userRepository;

    public AuthService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public void userRegister(User request){
        User newUser = new User();
        newUser.setUsername(request.getUsername());
        newUser.setEmail(request.getEmail());
        newUser.setHashPassword(request.getHashPassword());
        newUser.setUserType("GERENTE");
        newUser.setUserStatus("ATIVO");

        userRepository.save(newUser);
    }

}