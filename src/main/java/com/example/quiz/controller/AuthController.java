package com.example.quiz.controller;

import com.example.quiz.entity.User;
import com.example.quiz.model.RegisterRequest;
import com.example.quiz.repository.UserRepository;
import com.example.quiz.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("zequiz/auth")
public class AuthController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtUtil jwtUtils;


    @PostMapping(
            path = "/register"
    )
    public ResponseEntity<?> registerNewUser(
            @RequestBody RegisterRequest request
    ) {
        // cek jika sudah username sama di database
        if(userRepository.existsByUsername(request.getUsername())) {
            return ResponseEntity.badRequest().body("username already exist");
        }

        // Buat user baru
        User newUser = User.builder()
                .username(request.getUsername())
                .password(encoder.encode(request.getPassword()))
                .grade(request.getGrade())
                .build();

        // Simpan user baru
        userRepository.save(newUser);

        return ResponseEntity.ok("User registered successfully");
    }
}
