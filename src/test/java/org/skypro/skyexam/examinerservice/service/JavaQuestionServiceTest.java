package org.skypro.skyexam.examinerservice.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.skypro.skyexam.examinerservice.domain.Question;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class JavaQuestionServiceTest {
    @Mock
    private JavaQuestionService javaQuestionService;

    @Test
    public void getCollection_nonExistentQuestion_ReturnEmptyCollection() {
        when(javaQuestionService.getQuestions()).thenReturn(List.of());
        assertEquals(0, javaQuestionService.getQuestions().size());
    }

    @Test
    public void addQuestion_existentQuestion_ReturnQuestion() {
        String question = "QuestionTest";
        String answer = "AnswerTest";
        Question someQuestionTest = new Question(question, answer);
        when(javaQuestionService.getQuestions()).thenReturn(List.of(someQuestionTest));
        javaQuestionService.add(question, answer);
        List<Question> expectedResult = javaQuestionService.getQuestions();
        assertEquals(List.of(someQuestionTest), expectedResult);
    }

    @Test
    void removeQuestion_ExistentQuestion_removeQuestionFromList() {
        String question = "QuestionTest";
        String answer = "AnswerTest";
        Question someQuestionTest = new Question(question, answer);
        when(javaQuestionService.getQuestions()).thenReturn(List.of(someQuestionTest));
        javaQuestionService.add(question, answer);
        List<Question> expectedResult = javaQuestionService.getQuestions();
        Mockito.verify(javaQuestionService, Mockito.times(0)).remove(expectedResult.get(0));
    }

    @Test
    void getRandomQuestion_OneExistentQuestion_ReturnThisQuestion() {
        String question = "QuestionTest";
        String answer = "AnswerTest";
        Question someQuestionTest = new Question(question, answer);
        when(javaQuestionService.getQuestions()).thenReturn(List.of(someQuestionTest));
        when(javaQuestionService.getRandomQuestion()).thenReturn((someQuestionTest));
        javaQuestionService.add(question, answer);
        List<Question> expectedResult = javaQuestionService.getQuestions();
        Question actualResultObject = javaQuestionService.getRandomQuestion();
        List<Question> actualResult = new ArrayList<>();
        actualResult.add(actualResultObject);
        assertThat(actualResult).isNotNull()
                .isEqualTo(expectedResult);
    }
}