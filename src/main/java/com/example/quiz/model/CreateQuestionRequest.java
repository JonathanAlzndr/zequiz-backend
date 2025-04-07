package com.example.quiz.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateQuestionRequest {
    private String pertanyaan;
    private String opsiPertama;
    private String opsiKedua;
    private String opsiKetiga;
    private String opsiKeempat;
    private String jawabanBenar;
}
