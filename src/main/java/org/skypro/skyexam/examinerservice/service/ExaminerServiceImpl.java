package org.skypro.skyexam.examinerservice.service;

import org.skypro.skyexam.examinerservice.domain.Question;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class ExaminerServiceImpl implements ExaminerService {
    private final QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        List<Question> questions = questionService.getQuestions();
        if (questions.size() < amount) {
            throw new MoreQuestionsRequestedException("- Запрошено вопросов: " + String.valueOf(amount) + ", Вопросов в наличии: " + String.valueOf(questions.size()));
        }
        List<Question> results = new ArrayList<>();
        while (results.size() < amount) {
            Question result = questionService.getRandomQuestion();
            results.add(result);
        }
        return results;
    }
}
