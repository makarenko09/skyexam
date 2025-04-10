package org.skypro.skyexam.examinerservice.service;

import org.skypro.skyexam.examinerservice.domain.Question;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service

public class JavaQuestionService implements QuestionService {
    private List<Question> questions;
    java.util.Random random = new java.util.Random();
    public JavaQuestionService() {
        questions = new ArrayList<>();
    }

    @Override
    public Question add(Question question) {
        if (questions.contains(question)) {
            throw new IllegalArgumentException("Duplicate question");
        }
        questions.add(question);
        return questions.get(this.questions.size() - 1);
    }

    @Override
    public Question add(String question, String answer) {
        Question questionObject = new Question(question, answer);
        if (questions.contains(questionObject)) {
            throw new QuestionIsBusyException("- Duplicate question: " + questionObject);
        }
        questions.add(questionObject);
            return questions.get(this.questions.size() - 1);
    }

    @Override
    public Question remove(Question question) {
        if (questions.size() == 0 || !questions.contains(question)) {
            throw new NoSuchQuestionException("- Вопрос: " + question + " не найден");
        }
        questions.removeIf(temp -> temp.getQuestion().equals(question.getQuestion()));
        return question;
    }

    @Override
    public List<Question> getQuestions() {
        return new ArrayList<>(Optional.of(questions).orElse(new ArrayList<>()));
    }

    @Override
    public Question getRandomQuestion() {
        return questions.get(random.nextInt(questions.size()));
    }
}

