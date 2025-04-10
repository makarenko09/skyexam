package org.skypro.skyexam.examinerservice.controller;

import org.skypro.skyexam.examinerservice.domain.Question;
import org.skypro.skyexam.examinerservice.service.ExamError;
import org.skypro.skyexam.examinerservice.service.JavaQuestionService;
import org.skypro.skyexam.examinerservice.service.NoSuchQuestionException;
import org.skypro.skyexam.examinerservice.service.QuestionIsBusyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Collection;

@RestController
@RequestMapping("/exam/java")
public class JavaQuestionController {
    private final JavaQuestionService questionService;

    public JavaQuestionController(JavaQuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping("/")
    public Collection<Question> getQuestions() {
        return questionService.getQuestions();
    }

    @ExceptionHandler(NoSuchQuestionException.class)
    public ResponseEntity<ExamError> handleNoSuchQuestionException(NoSuchQuestionException e) {
        String code = "NOT_FOUND";
        String message = String.format("%s %s", LocalDateTime.now(), e.getMessage());
        ExamError examError = new ExamError(code, message);
        return new ResponseEntity<ExamError>(examError, HttpStatus.NOT_FOUND);
    }
    @GetMapping("/remove")
    @ResponseBody
    public Question removeQuestion(@RequestParam("question") String question, @RequestParam("answer") String answer) {
        Question object = new Question(question, answer);
        return questionService.remove(object);
    }

    @ExceptionHandler(QuestionIsBusyException.class)
    public ResponseEntity<ExamError> handleQuestionIsBusyException(QuestionIsBusyException e) {
        String code = "FORBIDDEN";
        String message = String.format("%s %s", LocalDateTime.now(), e.getMessage());
        ExamError examError = new ExamError(code, message);
        return new ResponseEntity<ExamError>(examError, HttpStatus.FORBIDDEN);
    }
    @GetMapping("/add")
    @ResponseBody
    public Question addQuestion(@RequestParam("question") String question, @RequestParam("answer") String answer) {
        return questionService.add(question, answer);
    }
}



