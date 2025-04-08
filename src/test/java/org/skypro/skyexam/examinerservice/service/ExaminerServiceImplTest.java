package org.skypro.skyexam.examinerservice.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.skypro.skyexam.examinerservice.domain.Question;

import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ExaminerServiceImplTest {

    @InjectMocks
    private ExaminerServiceImpl examinerService;
    @Mock
    private QuestionService javaQuestionService;

    @Test
    void getQuestions_NonExistentQuestion_throwsException() {
        when(javaQuestionService.getQuestions()).thenReturn(List.of());
        assertThrows(MoreQuestionsRequestedException.class, () -> examinerService.getQuestions(2));
    }

    @Test
    void getQuestions_OneExistentQuestion_returnQuestion() {
        String question = "QuestionTest";
        String answer = "AnswerTest";
        Question someQuestionTest = new Question(question, answer);
        when(javaQuestionService.getQuestions()).thenReturn(List.of(someQuestionTest));
        javaQuestionService.add(someQuestionTest);
        when(javaQuestionService.getRandomQuestion()).thenReturn(someQuestionTest);
//        assertEquals(someQuestionTest, examinerService.getQuestions(1));
        Collection<Question> actualResult = examinerService.getQuestions(1);
        assertEquals(1, actualResult.size());
    }
}