package com.example.quiz.service;

import com.example.quiz.entity.Topic;
import com.example.quiz.model.TopicRequest;
import com.example.quiz.repository.TopicRepository;
import com.example.quiz.repository.UserRepository;
import com.example.quiz.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TopicService {

    @Autowired
    private TopicRepository topicRepository;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public void createTopic(TopicRequest request) {
        Topic newTopic = Topic.builder()
                .topicName(request.getTopicName())
                .build();

        topicRepository.save(newTopic);
    }

    public List<Topic> getAllTopics() {
        return topicRepository.findAll();
    }

}
