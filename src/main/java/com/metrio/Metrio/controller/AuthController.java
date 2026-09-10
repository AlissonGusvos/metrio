package com.metrio.Metrio.controller;

import com.metrio.Metrio.dto.UserLoginRequest;
import com.metrio.Metrio.dto.UserRegisterRequest;
import com.metrio.Metrio.service.AuthService;
import jakarta.servlet.http.HttpSession;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService){
        this.authService = authService;
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody UserRegisterRequest request){
        authService.userRegister(request);
        return ResponseEntity.ok("Usuário cadastrado");
    }

    @PostMapping("/login")
    public String login(@RequestBody UserLoginRequest request, HttpSession session){
        authService.userLogin(request, session);
        return "Logado!";
    }

    @PostMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "Deslogado!";
    }

    /*
    TESTE DE SESSÃO

    @GetMapping("/me")
    public String me(HttpSession session){
        Long userId = (Long) session.getAttribute("userId");

        if (userId == null){
            return "Usuário não logado";
        }

        return "Usuário logado: " + userId;
    }

     */
}