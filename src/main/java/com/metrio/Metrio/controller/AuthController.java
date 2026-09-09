package com.metrio.Metrio.controller;

import com.metrio.Metrio.models.User;
import com.metrio.Metrio.service.AuthService;
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
    public ResponseEntity<String> register(@RequestBody User request){
        authService.userRegister(request);
        return ResponseEntity.ok("Usuário cadastrado");
    }
}