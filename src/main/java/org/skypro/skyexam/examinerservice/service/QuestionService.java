package org.skypro.skyexam.examinerservice.service;

import org.skypro.skyexam.examinerservice.domain.Question;

import java.util.List;

public interface QuestionService {

    //    Collection<Question> getQuestions(int amount) {
//        return
//    };
    List<Question> getQuestions();

    Question getRandomQuestion();

    Question add(Question question);

    Question remove(String question, String answer);

}
