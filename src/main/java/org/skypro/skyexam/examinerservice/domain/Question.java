package org.skypro.skyexam.examinerservice.domain;

import java.util.Objects;
import java.util.regex.Pattern;

public class Question {
    private String question;
    private String answer;

    public Question(String question, String answer) {
        if (!Pattern.matches("^.{2,100}$", question)) {
            throw new IllegalArgumentException("Некорректной вопрос");
        }
        this.question = question;
        this.answer = answer;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Question)) return false;
        return Objects.equals(question, ((Question) o).question) && Objects.equals(answer, ((Question) o).answer);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(question);
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    @Override
    public String toString() {
        return "Question{" +
                "question='" + question + '\'' +
                ", answer='" + answer + '\'' +
                '}';
    }
}
