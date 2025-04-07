package org.skypro.skyexam.examinerservice.service;

import org.skypro.skyexam.examinerservice.domain.Question;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service

public class JavaQuestionService implements QuestionService {
    private List<Question> questions;

    public JavaQuestionService() {
        questions = new ArrayList<>();
    }

    @Override
    public Question add(Question question) {
        if (!questions.contains(question)) {
            questions.add(question);
            return questions.get(this.questions.size() - 1);
        } else {
            throw new IllegalArgumentException("Duplicate question");
        }
    }

    @Override
    public Question add(String question, String answer) {
        if (!questions.contains(new Question(question, answer))) {
            questions.add(new Question(question, answer));
            return questions.get(this.questions.size() - 1);
        } else {
            throw new IllegalArgumentException("Duplicate question");
        }
    }

    @Override
    public Question remove(Question question) {
        if (questions.size() == 0 || !questions.contains(question)) {
            throw new NoSuchQuestionException();
        }

        Iterator<Question> iterator = questions.iterator();
        while (iterator.hasNext()) {
            Question temp = iterator.next();
            if (temp.getQuestion().equals(question.getQuestion())) {
                iterator.remove();
            }
        }
        return new Question(question.getQuestion(), question.getAnswer());
    }

    @Override
    public List<Question> getQuestions() {
//        Optional.ofNullable(new ArrayList<>(questions));

        return new ArrayList<>(Optional.ofNullable(questions).orElse(new ArrayList<>()));
    }

    @Override
    public Question getRandomQuestion() {
        java.util.Random random = new java.util.Random();
        return questions.get(random.nextInt(questions.size()));
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }
}
