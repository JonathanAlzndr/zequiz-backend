package com.example.quiz.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "topic")
public class Topic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="topic_id")
    private Integer topicId;

    @Column(name = "topic_name")
    private String topicName;

    @OneToMany(mappedBy = "topic")
    private List<Question> questions;

}
