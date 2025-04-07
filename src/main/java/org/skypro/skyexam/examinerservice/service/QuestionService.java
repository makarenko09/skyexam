package org.skypro.skyexam.examinerservice.service;

import org.skypro.skyexam.examinerservice.domain.Question;

import java.util.List;

public interface QuestionService {

    List<Question> getQuestions();

    Question getRandomQuestion();

    Question add(Question question);
    Question add(String question, String answer);

    Question remove(Question question);

}
