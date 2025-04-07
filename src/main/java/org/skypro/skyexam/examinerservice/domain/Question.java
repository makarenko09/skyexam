package org.skypro.skyexam.examinerservice.domain;

import java.util.Objects;

public class Question {
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Question)) return false;
        return Objects.equals(question, ((Question) o).question);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(question);
    }

    private String question;
    private String answer;

    public Question(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }

    @Override
    public String toString() {
        return "Question{" +
                "question='" + question + '\'' +
                ", answer='" + answer + '\'' +
                '}';
    }
}
