package com.metrio.Metrio.service;

import com.metrio.Metrio.configuration.EncriptConfig;
import com.metrio.Metrio.dto.UserLoginRequest;
import com.metrio.Metrio.dto.UserRegisterRequest;
import com.metrio.Metrio.models.User;
import com.metrio.Metrio.repository.UserRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final EncriptConfig encriptConfig;

    public AuthService(UserRepository userRepository, EncriptConfig encriptConfig){
        this.userRepository = userRepository;
        this.encriptConfig = encriptConfig;
    }

    public void userRegister(UserRegisterRequest request){

        User user = new User();

        user.setUsername(request.username());
        user.setEmail(request.email());

        String hashPassword = encriptConfig.passwordEncoder().encode(request.password());
        user.setHashPassword(hashPassword);

        user.setUserType("ASSISTENTE");
        user.setUserStatus("ATIVO");

        userRepository.save(user);
    }

    public void userLogin(UserLoginRequest request, HttpSession session){

        Optional<User> userOptional = userRepository.findByEmail(request.email());

        if (userOptional.isEmpty()){
            throw new RuntimeException("E-mail ou senha inválidos");
        }

        User user = userOptional.get();

        if (encriptConfig.passwordEncoder().matches(user.getHashPassword(), request.password())){
            throw new RuntimeException("E-mail ou senha inválidos");
        }

        session.setAttribute("userId", user.getId());
    }

}