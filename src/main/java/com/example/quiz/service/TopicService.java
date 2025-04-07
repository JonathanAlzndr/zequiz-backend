package com.example.quiz.service;

import com.example.quiz.entity.Topic;
import com.example.quiz.model.CreateQuestionRequestBody;
import com.example.quiz.model.CreateTopicRequestBody;
import com.example.quiz.repository.TopicRepository;
import com.example.quiz.repository.UserRepository;
import com.example.quiz.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TopicService {

    @Autowired
    private TopicRepository topicRepository;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public void createTopic(CreateTopicRequestBody request) {
        Topic newTopic = Topic.builder()
                .topicName(request.getTopicName())
                .build();

        topicRepository.save(newTopic);
    }

}
