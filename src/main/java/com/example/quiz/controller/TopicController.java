package com.example.quiz.controller;

import com.example.quiz.model.CreateQuestionRequestBody;
import com.example.quiz.model.CreateTopicRequestBody;
import com.example.quiz.repository.TopicRepository;
import com.example.quiz.repository.UserRepository;
import com.example.quiz.security.JwtUtil;
import com.example.quiz.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TopicController {


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TopicRepository topicRepository;

    @Autowired
    private TopicService topicService;

    @Autowired
    JwtUtil jwtUtils;

    @PostMapping(
            path = "zequiz/topic"
    )
    public ResponseEntity<?> createTopic(
            @RequestHeader("Authorization") String authHeader,
            @RequestBody CreateTopicRequestBody request
    ) {
        // Cek jika ada token
        if(authHeader == null || !authHeader.startsWith("Bearer ")) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("JWT Token is missing");
        }

        // Cek jika token valid
        String token = authHeader.substring(7);
        if(!jwtUtils.validateJwtToken(token)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid JWT token");
        }

        // panggil topicService untuk menyimpan topic di database
        topicService.createTopic(request);

        return ResponseEntity.ok("Created Successfully");
    }
}
