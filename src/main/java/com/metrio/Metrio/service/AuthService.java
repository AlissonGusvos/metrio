package com.metrio.Metrio.service;

import com.metrio.Metrio.dto.UserLoginRequest;
import com.metrio.Metrio.dto.UserRegisterRequest;
import com.metrio.Metrio.models.User;
import com.metrio.Metrio.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

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

    public String userLogin(UserLoginRequest request){

        Optional<User> userOptional = userRepository.findByEmail(request.email());

        if (userOptional.isEmpty()){
            return "E-mail ou senha inválidos";
        }

        User user = userOptional.get();

        if (user.getEmail().equals(request.email())){
            if (user.getHashPassword().equals(request.password())){
                return "Login feito com sucesso";
            }
            else {
                return "E-mail ou senha inválidos";
            }
        }
        else {
            return "E-mail ou senha inválidos";
        }

    }

}