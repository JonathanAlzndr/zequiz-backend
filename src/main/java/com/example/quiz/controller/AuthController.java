package com.example.quiz.controller;

import com.example.quiz.entity.User;
import com.example.quiz.model.LoginRequestBody;
import com.example.quiz.model.LoginResponseBody;
import com.example.quiz.model.RegisterRequest;
import com.example.quiz.repository.UserRepository;
import com.example.quiz.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

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

    @PostMapping(
            path = "/login"
    )
    public ResponseEntity<?> login(@RequestBody LoginRequestBody request) {

        // Cek jika username telah ada di database
        User user = userRepository.findByUsername(request.getUsername()).orElseThrow(
                () -> new UsernameNotFoundException("Username not found : " + request.getUsername())
        );

        // cek jika user null atau tidak
        if(user == null) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Username not found");
        }

        // Cek jika password sesuai
        if(!encoder.matches(request.getPassword(), user.getPassword())) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Invalid password");
        }

        // Jika password sesuai
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );

        UserDetails userDetails = (UserDetails) authentication.getPrincipal();

        // Membuat token
        String token = jwtUtils.generateToken(user.getUsername());
        LoginResponseBody loginResponseBody = LoginResponseBody.builder()
                .message("Login Successfully")
                .token(token)
                .build();

        return ResponseEntity.ok(loginResponseBody);
    }

}
