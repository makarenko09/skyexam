package org.skypro.skyexam.examinerservice.service;

import org.skypro.skyexam.examinerservice.domain.Question;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JavaQuestionService implements QuestionService {
    private final List<Question> questions;


    //TODO - Разобраться с конструтктором
    public JavaQuestionService(List<Question> questions) {
        this.questions = questions;
    }

    @Override
    public Question add(Question question) {
        if (!questions.contains(question)) {
            questions.add(question);
        } else {
            throw new IllegalArgumentException("Duplicate question");
        }
        return this.questions.get(questions.indexOf(question));
    }

    public Question add(String question, String answer) {
        Question result = null;
        for (Question q : questions) {
            if (!q.getQuestion().equals(question) && !q.getAnswer().equals(answer)) {
                result = new Question(question, answer);
                this.add(result);
            } else {
                throw new IllegalArgumentException("Duplicate question");
            }
        }
        return this.questions.get(questions.indexOf(result));
    }

    @Override
    public Question remove(String question, String answer) {
        Question toRemove = new Question(question, answer);
        if (questions.remove(toRemove)) {
            System.out.println("Question removed: " + question);
        } else {
            System.out.println("Question not found: " + question);
        }
        return toRemove;
    }

    @Override
    public List<Question> getQuestions() {
        return questions;
    }

    @Override
    public Question getRandomQuestion() {
        java.util.Random random = new java.util.Random();
        return questions.get(random.nextInt(questions.size()));
    }
}
