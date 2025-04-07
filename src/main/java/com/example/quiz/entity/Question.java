package com.example.quiz.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "question")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer questionId;

    @ManyToOne
    @JoinColumn(
            name = "topic_id",
            referencedColumnName = "topic_id"
    )
    private Topic topic;

    private String pertanyaan;

    @Column(name = "opsi_pertama")
    private String opsiPertama;

    @Column(name = "opsi_kedua")
    private String opsiKedua;

    @Column(name = "opsi_ketiga")
    private String opsiKetiga;

    @Column(name = "opsi_keempat")
    private String opsiKeempat;

    @Column(name = "jawaban_benar")
    private String jawabanBenar;
}
