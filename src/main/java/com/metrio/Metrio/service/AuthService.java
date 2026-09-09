package com.metrio.Metrio.service;

import com.metrio.Metrio.dto.UserRegisterRequest;
import com.metrio.Metrio.models.User;
import com.metrio.Metrio.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UserRepository userRepository;

    public AuthService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public void userRegister(UserRegisterRequest request){

        User user = new User();

        user.setUsername(request.username());
        user.setEmail(request.email());
        user.setHashPassword(request.password());
        user.setUserType("ASSISTENTE");
        user.setUserStatus("ATIVO");

        userRepository.save(user);
    }

}