package com.example.quiz.service;

import com.example.quiz.entity.Topic;
import com.example.quiz.model.TopicRequest;
import com.example.quiz.repository.TopicRepository;
import com.example.quiz.repository.UserRepository;
import com.example.quiz.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

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

    @Transactional
    public void updateTopic(Integer topicId, String topicNewName) {

        Topic topic = topicRepository.findById(topicId).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Failed to update post availability"));

        topic.setTopicName(topicNewName);
        topicRepository.save(topic);
    }

}
